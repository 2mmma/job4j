package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "1", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
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
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    //добавляем заявку, затем удаляем ее. проверяем id на null
    @Test
    public void whenUserAddItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name","desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input,tracker).init();
        assertNull(tracker.findById(item.getId()));
    }

    //добавляем заявки и находим их по названию
    @Test
    public void whenUserAddItemsThenTrackerFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test","byName"));
        Item item2 = tracker.add(new Item("test2","byName2"));
        Input input = new StubInput(new String[]{"5", "test", "6"});
        new StartUI(input,tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test"));

    }
}
