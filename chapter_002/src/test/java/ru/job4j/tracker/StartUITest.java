package ru.job4j.tracker;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 01.2019
 */
public class StartUITest {

    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final StringBuilder MENU =
            new StringBuilder()
            .append("0->Добавить новую заявку")
            .append(System.lineSeparator())
            .append("1->Показать все заявки")
            .append(System.lineSeparator())
            .append("2->Изменить заявку")
            .append(System.lineSeparator())
            .append("3->Удалить заявку")
            .append(System.lineSeparator())
            .append("4->Поиск заявки по ID")
            .append(System.lineSeparator())
            .append("5->Поиск заявки по имени")
            .append(System.lineSeparator())
            .append("6->Выход");

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "no", "1", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(MENU)
                                .append(System.lineSeparator())
                                .append("----------Редактирование заявки----------")
                                .append(System.lineSeparator())
                                .append("Заявка успешно изменена")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    //добавляем заявку, затем удаляем ее. проверяем id на null
    @Test
    public void whenUserAddItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name","desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input,tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(MENU)
                                .append(System.lineSeparator())
                                .append("----------Удаление заявки----------")
                                .append(System.lineSeparator())
                                .append("Заявка удалена")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    //добавляем заявки и находим их по названию
    @Test
    public void whenUserAddItemThenTrackerFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test","byName"));
        Input input = new StubInput(new String[]{"5", "test", "6"});
        new StartUI(input,tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(MENU)
                                .append(System.lineSeparator())
                                .append("----------Поиск заявки по имени----------")
                                .append(System.lineSeparator())
                                .append(item.toString())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUserAddItemsThenTrackerFindAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1","first"));
        Item item2 = tracker.add(new Item("test2","second"));
        Item item3 = tracker.add(new Item("test3","third"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input,tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(MENU)
                                .append(System.lineSeparator())
                                .append("----------Все заявки----------")
                                .append(System.lineSeparator())
                                .append(item1.toString())
                                .append(System.lineSeparator())
                                .append(item2.toString())
                                .append(System.lineSeparator())
                                .append(item3.toString())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}