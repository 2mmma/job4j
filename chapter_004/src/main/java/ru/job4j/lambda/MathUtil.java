package ru.job4j.lambda;

/**
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class MathUtil {

    /**
     * метод прибавляет два числа
     * @param left - первое число
     * @param second - второе число
     * @return сумма чисел
     * */
    public static double add(int left, int second) {
        return left + second;
    }

    /**
     * метод делит первое число на второе
     * @param left - первое число
     * @param second - второе число
     * @return результат деления чисел
     * */
    public static double div(int left, int second) {
        return left / second;
    }
}
