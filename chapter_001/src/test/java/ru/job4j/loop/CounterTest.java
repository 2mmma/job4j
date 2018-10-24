package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    /**
     * Тестируем метод add в диапазоне от 1 до 20.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTwentyThen110() {
        Counter counter = new Counter();
        int result = counter.add(1, 20);
        assertThat(result, is(110));
    }
}