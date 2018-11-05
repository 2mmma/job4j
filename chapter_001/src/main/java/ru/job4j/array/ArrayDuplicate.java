package ru.job4j.array;

import java.util.Arrays;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 11.2018*/
public class ArrayDuplicate {

    /**
     * метод удалаяет дубликаты из массива
     * @param array массив строк
     * @return array массив без дубликатов*/
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
