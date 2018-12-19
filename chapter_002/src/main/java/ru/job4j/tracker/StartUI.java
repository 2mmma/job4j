package ru.job4j.tracker;

/**
 * @version 1.0
 * @since 12.2018
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 */

public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для .
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String FINDbyID = "4";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String FINDbyNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.findAllItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDbyID.equals(answer)) {
                this.findByIdItem();
            } else if (FINDbyNAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка добавлена. Id: " + item.getId() + " -----------");
    }

    /**
     * Метод показывает все заявки
     */
    private void findAllItem() {
        System.out.println("----------Все заявки----------");
        Item[] itemsAll = tracker.findAll();
        if(itemsAll.length == 0 ) {
            System.out.println("Заявок нет!");
        } else {
            for (Item item: itemsAll) {
                System.out.println(item.toString());
            }
        }
    }

    /**
     * Метод редактирует заявки
     */
    private void editItem() {
        System.out.println("----------Редактирование заявки----------");
        String id = input.ask("Введите ID заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("Заявка успешно изменена");
        } else {
        System.out.println("Заявка не найдена");
        }
    }

    /**
     * Метод удаляет заявки
     */
    private void deleteItem() {
        System.out.println("----------Удаление заявки----------");
        String id = input.ask("Введите ID заявки: ");
        if (tracker.delete(id)) {
        System.out.println("Заявка удалена");
        } else {
        System.out.println("Заявка не найдена");
        }
    }

    /**
     * Метод реализует поиск заявки по Id
     */
    private void findByIdItem() {
        System.out.println("----------Поиск заявки по ID----------");
        String id = input.ask("Введите ID заявки:");
        Item item = tracker.findById(id);
        if (item != null) {
        System.out.println(item.toString());
        } else {
        System.out.println("Заявки с указанным ID не найдено");
        }
        }

    /**
     * Метод реализует поиск заявки по имени
     */
    private void findByNameItem() {
        System.out.println("----------Поиск заявки по имени----------");
        String name = input.ask("Введите имя заявки:");
        Item[] itemsByName = tracker.findByName(name);
        if(itemsByName.length == 0 ) {
            System.out.println("Заявки с указанным именем не найдено");
        } else {
            for (Item item: itemsByName) {
                System.out.println(item.toString());
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню:\n" +
                "0.Добавить новую заявку\n" +
                "1.Показать все заявки\n" +
                "2.Изменить заявку\n" +
                "3.Удалить заявку\n" +
                "4.Поиск заявки по ID\n" +
                "5.Поиск заявки по имени\n" +
                "6.Выход");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
