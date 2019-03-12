package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class DiapasonFunctionTest {

    private final DiapasonFunction function = new DiapasonFunction();

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = function.diapason(1, 5, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(2D, 5D, 10D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        List<Double> result = function.diapason(1, 3, x -> Math.log(x) / Math.log(2) + 1);
        List<Double> expected = Arrays.asList(1D, 2D);
        assertThat(result, is(expected));
    }
}
