package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 03.2020
 */
public class DynamicArrayContainer<E> implements Iterable {

    private E[] array;
    private int arrayIndex = 0;
    private int modCount = 0;

    public DynamicArrayContainer(int size) {
        array = (E[]) new Object[size];
    }

    public E get(int index) {
        return array[index];
    }

    public void add(E value) {
        resize();
        array[arrayIndex++] = value;
        modCount++;
    }

    public void resize() {
        if (arrayIndex == this.array.length) {
            this.array = Arrays.copyOf(this.array, this.array.length + array.length);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return currentIndex < array.length;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[currentIndex++];
            }
        };
    }
}
