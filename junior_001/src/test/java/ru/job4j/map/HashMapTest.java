package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class HashMapTest {
    private HashMap<String, Integer> map;

    @Before
    public void load() {
        map = new HashMap<>();
    }

    @Test
    public void whenInsertNewElementThenDelete() {
        assertTrue(map.insert("A", 1));
        assertThat(map.get("A"), is(1));
        assertTrue(map.delete("A"));
        assertTrue(map.isEmpty());
    }

    @Test
    public void whenInsertDuplicate() {
        assertTrue(map.insert("A", 1));
        assertFalse(map.insert("A", 1));
        assertThat(map.size(), is(1));
    }


    @Test
    public void whenInsertSomeElementsThenResize() {
        assertTrue(map.insert("A", 1));
        assertTrue(map.insert("B", 2));
        assertTrue(map.insert("C", 3));
        assertThat(map.size(), is(3));
        assertTrue(map.insert("D", 4));
        assertTrue(map.insert("E", 5));
        assertTrue(map.insert("F", 6));
        assertThat(map.size(), is(6));
        assertTrue(map.delete("B"));
        assertThat(map.size(), is(5));
        assertNull(map.get("B"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTestExceptionForCapacity() {
        new HashMap<String, Integer>(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTestExceptionForLoadFactor() {
        new HashMap<String, Integer>(1.1F);
    }

    @Test
    public void mapIteratorTest() {
        map.insert("A", 1);
        map.insert("B", 2);
        map.insert("C", 3);
        Iterator<HashMap.Entry<String, Integer>> iterator = map.iterator();
        HashMap.Entry<String, Integer> temp = iterator.next();
        assertThat(temp.key, is("A"));
        assertThat(temp.value, is(1));
        assertTrue(iterator.hasNext());
        temp = iterator.next();
        assertThat(temp.key, is("B"));
        assertThat(temp.value, is(2));
        assertTrue(iterator.hasNext());
        temp = iterator.next();
        assertThat(temp.key, is("C"));
        assertThat(temp.value, is(3));
        assertFalse(iterator.hasNext());
    }


    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorExceptionTestNewElement() {
        map.insert("A", 1);
        Iterator<HashMap.Entry<String, Integer>> iterator = map.iterator();
        HashMap.Entry<String, Integer> temp = iterator.next();
        assertThat(temp.key, is("A"));
        assertThat(temp.value, is(1));
        map.insert("B", 2);
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorExceptionTestDeleteElement() {
        map.insert("A", 1);
        map.insert("B", 2);
        Iterator<HashMap.Entry<String, Integer>> iterator = map.iterator();
        HashMap.Entry<String, Integer> temp = iterator.next();
        assertThat(temp.key, is("A"));
        assertThat(temp.value, is(1));
        map.delete("A");
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorExceptionTestNoSuchElement() {
        map.insert("A", 1);
        Iterator<HashMap.Entry<String, Integer>> iterator = map.iterator();
        HashMap.Entry<String, Integer> temp = iterator.next();
        assertThat(temp.key, is("A"));
        assertThat(temp.value, is(1));
        iterator.next();
    }
}
