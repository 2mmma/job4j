package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 01.2020
 */
public class SimpleArray<T> implements Iterable {

    private final Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        this.array[index++] = model;
    }

    public void set(int index, T model) {
        if (array[index] != null) {
            array[index] = model;
        }
    }

    public void remove(int index) {
        if (this.array.length - 1 - index >= 0) {
            System.arraycopy(this.array, index + 1, this.array, index, this.array.length - 1 - index);
        }
        this.array[this.array.length - 1] = null;
        this.index--;
    }

    Object get(int index) {
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < index;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[count++];
            }
        };
    }
}
