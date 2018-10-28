package ru.job4j.array;

/**
 * Программа возвращает индекс элемента в массиве
 * @author tumen.garmazhapov (gtb-85@yandex.ru).
 * @since 10.2018
 */
public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for ( int index = 0; index < data.length; index++ ) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
