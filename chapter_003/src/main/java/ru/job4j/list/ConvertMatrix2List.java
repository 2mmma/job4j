package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tumen.garmazhapov
 * @since 02.2019
 */
public class ConvertMatrix2List {
    /**
     * метод конвертирует двумерный массив в список
     * @param array - двумерный массив.
     * @return list - список.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] arr : array) {
            for (int count : arr) {
                list.add(count);
            }
        }
        return list;
    }
}
