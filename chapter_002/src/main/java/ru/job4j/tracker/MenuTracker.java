package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * @version 1.0
 * @since 01.2019
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 */
public class MenuTracker {

    private Input input;

    private Tracker tracker;

    private UserAction[] actions = new UserAction[7];

    /**
     * Конструктор.
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
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
        this.actions[0] = new CreateItem(0,"Добавить новую заявку");
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
                System.out.println(action.info());
            }
        }
    }

    public class CreateItem extends BaseAction {

        public CreateItem(int key, String menu) {
                super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки:");
            String desc = input.ask("Введите описание заявки:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка добавлена. Id: " + item.getId() + " -----------");
        }
    }

    public class FindAll extends BaseAction {

        public FindAll(int key, String menu) {
            super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------Все заявки----------");
            ArrayList<Item> itemsAll = tracker.findAll();
            if (itemsAll.size() == 0) {
                System.out.println("Заявок нет!");
            } else {
                for (Item item : itemsAll) {
                    System.out.println(item.toString());
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
            System.out.println("----------Редактирование заявки----------");
            String id = input.ask("Введите ID заявки:");
            Item item = tracker.findById(id);
            if (item != null) {
                String name = input.ask("Введите новое имя заявки:");
                String desc = input.ask("Введите новое описание заявки:");
                item = new Item(name, desc);
                tracker.replace(id, item);
                System.out.println("Заявка успешно изменена");
            } else {
                System.out.println("Заявка не найдена");
            }
        }
    }

    public class DeleteItem extends BaseAction{

        public DeleteItem(int key, String menu) {
            super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------Удаление заявки----------");
            String id = input.ask("Введите ID заявки: ");
            if (tracker.delete(id)) {
                System.out.println("Заявка удалена");
            } else {
                System.out.println("Заявка не найдена");
            }
        }
    }

    public class FindByIdItem extends BaseAction {

        public FindByIdItem(int key, String menu) {
            super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------Поиск заявки по ID----------");
            String id = input.ask("Введите ID заявки:");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Заявки с указанным ID не найдено");
            }
        }
    }

    public class FindByNameItem extends BaseAction {

        public FindByNameItem(int key, String menu) {
            super(key, menu);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------Поиск заявки по имени----------");
            String name = input.ask("Введите имя заявки:");
            ArrayList<Item> itemsByName = tracker.findByName(name);
            if (itemsByName.size() != 0) {
                for (Item item: itemsByName) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("Заявки с указанным именем не найдено");
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