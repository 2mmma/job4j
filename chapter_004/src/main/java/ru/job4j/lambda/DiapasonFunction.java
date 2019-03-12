package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class DiapasonFunction {


    interface Function<T> {
        T calculate(T t);
    }

    List<Double> diapason(int start, int end, Function<Double> func) {

        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(func.calculate((double) i));
        }
        return result;
    }
}
