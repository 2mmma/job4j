package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * В данном классе реализована работа с лямбда-выражениями
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class Calculator {


    /**
     * в интерфейсе Operation определен метод calc без реализации
     */
    public interface Operation {
        /**
         * метод принимает два числа int,
         * и возвращает некоторое число - double
         * @param left - первое число
         * @param right - второе число
         */
        double calc(int left, int right);
    }

    /**
     * в методе multiple с помощью встроенных функциональных интерфейсов
     * реализовано перемножение чисел в диапазоне start...finish на число value
     * @param start - начало диапазона чисел
     * @param finish - конец диапазона
     * @param value - число, на которое перемножаются числа в диапазоне
     * @param op - встроенный интерфейс BiFunction
     * @param media - встроенный интерфейс Consumer*/
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiple %s * %s = %s %n", value, index, result);
                    return result;
                },
                System.out::println
        );
    }
}

