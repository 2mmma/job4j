package ru.job4j.array;

 /**
  * Программа заполняет массив числами, возведенными в квадрат.
  * @author tumen.garmazhapov (gtb-85@yandex.ru).
  * @since 10.2018
  */

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0 ; i < bound; i++) {
            rst [ i ] = (int) Math.pow(i + 1 , 2);
            System.out.println( rst [ i ] );// Выводим результат на консоль.
        }
        return rst;
    }
}