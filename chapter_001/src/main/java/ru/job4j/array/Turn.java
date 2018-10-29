package ru.job4j.array;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 10.2018
 */

public class Turn {

    /**
     * метод переворачивает массив задом наперед
     * @param array массив чисел
     * @return array перевернутый массив
     * */
    public int[] back ( int[] array) {
        for ( int i = 0; i < array.length / 2 ; i++ ) {
            int temp = array [ i ];
            array [i] = array [ array.length - i - 1];
            array [ array.length - i - 1] = temp;
        }
        return array;
    }
}