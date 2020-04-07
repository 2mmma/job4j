package ru.job4j.set;

import ru.job4j.list.DynamicArrayContainer;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 04.2020
 */
public class SimpleSet<E> implements Iterable<E> {

    private final DynamicArrayContainer<E> container;

    public SimpleSet(int size) {
        container = new DynamicArrayContainer<>(size);
    }

    public boolean add(E value) {
        boolean result = false;
        if (checkDuplicate(value)) {
            container.add(value);
            result = true;
        }
        return result;
    }

    private boolean checkDuplicate(E value) {
        boolean result = true;
        Iterator<E> iterator = container.iterator();
        while (iterator.hasNext()) {
            if (Objects.equals(value, iterator.next())) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return container.iterator();
    }
}
