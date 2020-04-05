package ru.job4j.list;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 04.2020
 */
public class SimpleQueue<T> {

    private SimpleStack<T> input = new SimpleStack<>();

    private SimpleStack<T> output = new SimpleStack<>();

    public T poll() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.poll());
            }
        }
        return output.poll();
    }

    public void push(T value) {
        input.push(value);
    }
}
