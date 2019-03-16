package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * @version 1.0
 * @since 12.2018
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 */

public class StartUI {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    private final Consumer<String> output;

    /**
     * Запускт программы.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Выберите пункт меню:", menu.getActionsNum()));
        } while (!"6".equals(this.input.ask("Выйти?(6): ")));
    }


    /**
     * Константа меню для добавления новой заявки.
     * */
    private static final String ADD = "0";

    /**
     * Константа меню для просмотра всех заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для изменения заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по ID.
     */
    private static final String FINDBYID = "4";

    /**
     * Константа меню для поиска заявки по названию.
     */
    private static final String FINDBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
}
