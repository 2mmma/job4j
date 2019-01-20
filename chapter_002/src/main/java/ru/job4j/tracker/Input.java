package ru.job4j.tracker;

import java.util.List;

/**
 * @version 1.0
 * @since 12.2018
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 */

public interface Input {
    String ask(String question);

    int ask(String question, List<Integer> range);
}
