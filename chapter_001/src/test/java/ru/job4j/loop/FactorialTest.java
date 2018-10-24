package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenFactorialForThreeThenSix() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(3);
        assertThat(result, is(6));
    }

    @Test
    public void whenFactorialForZeroThenOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }
}
