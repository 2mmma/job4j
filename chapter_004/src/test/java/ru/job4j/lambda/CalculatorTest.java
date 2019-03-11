package ru.job4j.lambda;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса Calculator
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class CalculatorTest {
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                MathUtil::add,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }

    @Test
    public void whenMultiply1Until5By2() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                1, 5, 2,
                (value, index) -> (double) value * index,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(2D, 4D, 6D, 8D)));
    }

}
