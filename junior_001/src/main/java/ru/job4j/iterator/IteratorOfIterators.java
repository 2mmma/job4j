package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 01.2020
 */

public class IteratorOfIterators {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            Iterator<Integer> iterator = it.next();

            @Override
            public boolean hasNext() {
                while (!iterator.hasNext() && it.hasNext()) {
                    iterator = it.next();
                }
                return iterator.hasNext();
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}