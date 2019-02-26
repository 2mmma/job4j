package ru.job4j.list;

import java.util.*;

/**
 * @author tumen.garmazhapov
 * @since 02.2019
 */
public class ConvertList2Array {

    /**
     * метод конвертирует двумерный массив в список
     * @param list - список.
     * @return array - двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (int count : list) {
            array[row][cell++] = count;
            if (cell == array[row].length) {
                cell = 0;
                row++;
            }
        } return array;
    }

    /**
     * метод конвертирует список массивов в один список
     * @param list - список массивов.
     * @return result - список.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[]arr : list) {
            for (int count : arr) {
                result.add(count);
            }
        }
       return result;
    }
}