package ru.job4j.array;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 10.2018
 */
public class Check {
    /**
     * Метод проверяет, все ли элементы в массиве являются true или false.
     * @param data массив.
     * @return result.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
             result = false;
             break;
            }
        }
        return result;
    }
}