package ru.job4j.tracker;

import java.util.*;

/**
 * @version 1.0
 * @since 12.2018
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 */

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Введите число из диапазона меню!");
        }
    }
}
