package ru.job4j.iterator;

import java.util.Iterator;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 01.2020
 */

// в классе реализован шаблон Iterator
public class IteratorArray implements Iterator {

    private final int[][] array;
    private int rows = 0;
    private int cells = 0;


    public IteratorArray(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array.length > rows && array[rows].length > cells;
    }

    @Override
    public Object next() {
        int result = array[rows][cells];
        cells++;
        if (array[rows].length == cells) {
            cells = 0;
            rows++;
        }
        return result;
    }
}

