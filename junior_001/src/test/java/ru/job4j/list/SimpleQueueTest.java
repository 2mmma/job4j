package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {

    @Test
    public void whenPushThenPoll() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }

    @Test
    public void whenExceptionTest() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        assertThat(queue.poll(), is(1));
        boolean wasError = false;
        try {
            queue.poll();
        } catch (IllegalArgumentException iae) {
            wasError = true;
        }
        assertTrue(wasError);
    }
}