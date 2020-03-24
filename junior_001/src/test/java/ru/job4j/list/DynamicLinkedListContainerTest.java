package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DynamicLinkedListContainerTest {

    private DynamicLinkedListContainer<Integer> linkedList;

    @Before
    public void beforeTest() {
        linkedList = new DynamicLinkedListContainer<>();
        linkedList.add(123);
        linkedList.add(555);
        linkedList.add(5667);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOne() {
        assertThat(linkedList.get(1), is(555));
    }

    @Test
    public void whenAddNewElementThenResizeContainer() {
        linkedList.add(100);
        assertThat(linkedList.get(0), is(100));
        assertThat(linkedList.get(3), is(123));
    }

    @Test
    public void whenIteratorTest() {
        Iterator<Integer> it = linkedList.iterator();
        assertThat(it.next(), is(5667));
        assertTrue(it.hasNext());
        assertThat(it.next(), is(555));
        assertTrue(it.hasNext());
        assertThat(it.next(), is(123));
        assertFalse(it.hasNext());
    }

    @Test
    public void whenModificationCountTest() {
        Iterator<Integer> it = linkedList.iterator();
        assertThat(it.next(), is(5667));
        assertTrue(it.hasNext());
        linkedList.add(111);
        boolean wasError = false;
        try {
            it.next();
        } catch (ConcurrentModificationException cme) {
            wasError = true;
        }
        assertTrue(wasError);
    }
}
