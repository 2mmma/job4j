package ru.job4j.iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.NoSuchElementException;

public class BackwardArrayIteratorTest {

    @Test
    public void whenMultiCallhasNextThenTrue() {
        BackwardArrayIterator it = new BackwardArrayIterator(
                new int[]{1, 2, 3}
        );
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        BackwardArrayIterator it = new BackwardArrayIterator(
                new int[]{1, 2, 3, 4}
        );
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        BackwardArrayIterator it = new BackwardArrayIterator(
                new int[]{}
        );
        it.next();
    }
}