package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleSetTest {

    private final SimpleSet<Integer> set = new SimpleSet<>(3);

    @Before
    public void beforeTest() {
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    public void whenAddElementsThenAddNewElement() {
        assertTrue(set.add(4));
    }

    @Test
    public void whenAddElementsThenAddDuplicate() {
        assertFalse(set.add(2));
    }
}
