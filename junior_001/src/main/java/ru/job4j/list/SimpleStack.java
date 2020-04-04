package ru.job4j.list;

public class SimpleStack<T> {

    private DynamicLinkedListContainer<T> linked = new DynamicLinkedListContainer<>();

    /**
     * Метод возвращает последнее значение и удаляет его из коллекции.
     *
     * @return result - удаленное значение.
     */
    public T poll() {
        if (linked.getSize() == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return linked.deleteLast();
    }

    /**
     * Метод вставляет в начало stack данные.
     *
     * @param value - элемент для вставки.
     */
    public void push(T value) {
        linked.add(value);
    }
}
