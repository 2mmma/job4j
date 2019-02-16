package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size()/rows : list.size()/rows + 1;
        int[][] array = new int[rows][cells];
        int count = 0;
        for (int row = 0; row != rows; row++) {
            for (int cell = 0; cell != cells; cell++) {
                array[row][cell] = count >= list.size() ? 0 : list.get(count++);
            }
        }
        return array;
    }
}
