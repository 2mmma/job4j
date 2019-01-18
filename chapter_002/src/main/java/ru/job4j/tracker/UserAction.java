package ru.job4j.tracker;

/**
 * @version 1.0
 * @since 01.2019
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 */
public interface UserAction {

    /**
     * Метод возвращает ключ опции.
     * @return ключ
     */
    int key();

    /**
     * Основной метод.
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню
     */
    String info();
}
