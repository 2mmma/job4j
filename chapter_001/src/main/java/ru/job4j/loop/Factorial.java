package ru.job4j.loop;

/**
 *Программа вычисляет факториал числа n.
 */
public class Factorial {

    /**Метод calc возвращает факториал числа n
     * @author tumen.garmazhapov (gtb-85@yandex.ru)
     * @param n - число.
     * @return factorial.
     */
    public int calc(int n) {
        int factorial = 1;
        if ( n != 0 ) {
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
        }
        return factorial;
    }
}