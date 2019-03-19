package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Integer> result = new ArrayList<>();
        Arrays.stream(array).map(Arrays::stream)
                .forEach(stream -> stream.forEach(result::add));
        return result;
    }
}
