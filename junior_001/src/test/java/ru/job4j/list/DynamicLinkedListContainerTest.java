package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
}
