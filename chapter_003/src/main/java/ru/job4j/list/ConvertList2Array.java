package ru.job4j.list;

import java.util.*;

public class ConvertList2Array {

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
        }return array;
    }
}