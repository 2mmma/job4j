package ru.job4j.array;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 10.2018
 */

public class MatrixCheck {

    /**
     * метод проверяет boolean-массив по диагоналям
     * @param data - квадратный массив логических значений
     * @return result - true или false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
                if (data[i][i] != data[i + 1][i + 1] || data[i][data.length - i - 1] != data[i + 1][data.length - i - 2]) {
                    result = false;
                    break;
                }
        }
        return result;
    }
}
