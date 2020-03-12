package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicArrayContainerTest {

    private DynamicArrayContainer<Integer> container;

    @Before
    public void beforeTest() {
        container = new DynamicArrayContainer<>(3);
        container.add(123);
        container.add(555);
        container.add(7878);
    }

    @Test
    public void whenAddElementsThenGetElement() {
        assertThat(container.get(1), is(555));
    }

    @Test
    public void whenAddNewElementThenResizeContainer() {
        container.add(2020);
        assertThat(container.get(3), is(2020));
    }
}
