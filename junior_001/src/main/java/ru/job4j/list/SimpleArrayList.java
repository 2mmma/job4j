package ru.job4j.list;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 02.2020
 * Класс SimpleArrayList.
 */
public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Метод удаления первого элемент в списке.
     */
    public E delete() {
        if (size == 0) {
            throw new IllegalArgumentException("List is empty");
        } else {
            this.first = this.first.next;
            size--;
            if (size == 0) {
                throw new IllegalArgumentException("All objects are deleted. List is empty");
            }
            return this.first.data;
        }
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
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
}
