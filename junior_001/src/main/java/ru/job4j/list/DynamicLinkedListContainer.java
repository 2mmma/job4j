package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 03.2020
 */
public class DynamicLinkedListContainer<E> implements Iterable {

    private int size;
    private int modCount;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     *
     * @param value - элемент для вставки
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modCount++;
    }

    /**
     * Метод получения элемента по индексу.
     *
     * @param index индекс элемента;
     * @return - элемент по индексу
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод удаляет и возвращает последний добавленный элемент.
     */
    public E deleteLast() {
        Node<E> result = this.first;
        this.first = this.first.next;
        size--;
        return result.data;
    }

    int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> item = first;
            private int currentIndex = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> temp;
                temp = item;
                item = temp.next;
                currentIndex++;
                return temp.data;
            }
        };
    }
}
