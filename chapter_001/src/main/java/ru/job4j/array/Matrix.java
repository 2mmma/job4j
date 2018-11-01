package ru.job4j.array;

/**
 * @author tumen.garmazhapov
 * @since 10.2018
 */
public class Matrix {

    /**
     * таблица умножения
     * @param size - размер массива
     * @return table - таблица
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for ( int i = 0; i < size; i++ ) {
            for ( int j = 0; j < size; j++ ) {
               table[i][j] = (i +1) * (j + 1);
            }
        }
        return table;
    }
}