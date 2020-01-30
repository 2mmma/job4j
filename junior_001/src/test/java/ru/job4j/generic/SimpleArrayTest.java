package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    private final SimpleArray<Integer> simpleArray = new SimpleArray<>(6);

    @Test
    public void whenAddSomeNumberObjectsThenRemoveOne() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        assertThat(simpleArray.get(2), is(3));
        simpleArray.remove(2);
        assertThat(simpleArray.get(2), is(4));
        assertNull(simpleArray.get(3));
    }

    @Test
    public void whenAddSomeNumberObjectsThenSet() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.set(1, 4);
        assertThat(simpleArray.get(1), is(4));
        simpleArray.set(5, 6);
        assertNull(simpleArray.get(5));
        assertThat(simpleArray.get(3), is(6));
    }

    @Test
    public void whenAddSomeStringObjectsThenRemoveThenSet() {
        SimpleArray<String> simpleArray = new SimpleArray<>(6);
        simpleArray.add("dog");
        simpleArray.add("cat");
        simpleArray.add("pig");
        simpleArray.add("horse");
        assertThat(simpleArray.get(2), is("pig"));
        simpleArray.remove(2);
        assertThat(simpleArray.get(2), is("horse"));
        assertNull(simpleArray.get(3));
        simpleArray.set(0, "wolf");
        assertThat(simpleArray.get(0), is("wolf"));
        simpleArray.set(5, "bear");
        assertNull(simpleArray.get(5));
        assertThat(simpleArray.get(3), is("bear"));
    }

}