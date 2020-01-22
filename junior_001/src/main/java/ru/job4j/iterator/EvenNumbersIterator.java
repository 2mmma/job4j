package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 01.2020
 */

// итератор, возвращающий только четные числа
public class EvenNumbersIterator implements Iterator {

    private final int[] numbers;
    private int index = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * переопределенный метод возвращает true,
     * только если в массиве есть четные числа перед указателем.
     */
    @Override
    public boolean hasNext() {
        boolean check = false;
        while (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
                check = true;
                break;
            } else {
                index++;
            }
        }
        return check;
    }

    /**
     * переопределенный метод возвращает только четные числа.
     */
    @Override
    public Object next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }
}
