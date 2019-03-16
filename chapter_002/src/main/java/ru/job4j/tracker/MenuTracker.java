package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

/**
 * @version 1.0
 * @since 01.2019
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 */
public class MenuTracker {

    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;
    private final UserAction[] actions = new UserAction[7];

    /**
     * Конструктор.
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения массива меню.
     * @return длину массива
     */
    public int[] getActionsNum() {
        int[] range = new int[this.actions.length];
        for (int i = 0; i < this.actions.length; i++) {
            range[i] = i;
        }
        return range;
    }

    /**
     * Метод заполняет меню.
     */
    public void fillActions() {
        this.actions[0] = new CreateItem(0, "Добавить новую заявку");
        this.actions[1] = new FindAll(1, "Показать все заявки");
        this.actions[2] = new EditItem(2, "Изменить заявку");
        this.actions[3] = new DeleteItem(3, "Удалить заявку");
        this.actions[4] = new FindByIdItem(4, "Поиск заявки по ID");
        this.actions[5] = new FindByNameItem(5, "Поиск заявки по имени");
        this.actions[6] = new Exit(6, "Выход");
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    public class CreateItem extends BaseAction {

        public CreateItem(int key, String menu) {
                super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки:");
            String desc = input.ask("Введите описание заявки:");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ Новая заявка добавлена. Id: " + item.getId() + " -----------");
        }
    }

    public class FindAll extends BaseAction {

        public FindAll(int key, String menu) {
            super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("----------Все заявки----------");
            List<Item> itemsAll = tracker.findAll();
            if (itemsAll.size() == 0) {
                output.accept("Заявок нет!");
            } else {
                for (Item item : itemsAll) {
                    output.accept(item.toString());
                }
            }
        }
    }

    public class EditItem extends BaseAction {

        public EditItem(int key, String menu) {
            super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("----------Редактирование заявки----------");
            String id = input.ask("Введите ID заявки:");
            Item item = tracker.findById(id);
            if (item != null) {
                String name = input.ask("Введите новое имя заявки:");
                String desc = input.ask("Введите новое описание заявки:");
                item = new Item(name, desc);
                tracker.replace(id, item);
                output.accept("Заявка успешно изменена");
            } else {
                output.accept("Заявка не найдена");
            }
        }
    }

    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String menu) {
            super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("----------Удаление заявки----------");
            String id = input.ask("Введите ID заявки: ");
            if (tracker.delete(id)) {
                output.accept("Заявка удалена");
            } else {
                output.accept("Заявка не найдена");
            }
        }
    }

    public class FindByIdItem extends BaseAction {

        public FindByIdItem(int key, String menu) {
            super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("----------Поиск заявки по ID----------");
            String id = input.ask("Введите ID заявки:");
            Item item = tracker.findById(id);
            if (item != null) {
                output.accept(item.toString());
            } else {
                output.accept("Заявки с указанным ID не найдено");
            }
        }
    }

    public class FindByNameItem extends BaseAction {

        public FindByNameItem(int key, String menu) {
            super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("----------Поиск заявки по имени----------");
            String name = input.ask("Введите имя заявки:");
            List<Item> itemsByName = tracker.findByName(name);
            if (itemsByName.size() != 0) {
                for (Item item: itemsByName) {
                    output.accept(item.toString());
                }
            } else {
                output.accept("Заявки с указанным именем не найдено");
            }
        }
    }

    public class Exit extends BaseAction {

        public Exit(int key, String menu) {
            super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }
}