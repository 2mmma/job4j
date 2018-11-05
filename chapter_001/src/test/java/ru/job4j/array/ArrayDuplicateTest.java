package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

    public class ArrayDuplicateTest {
        @Test
        public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
            String[] input = {"Dog", "Cat", "Dog", "Mouse", "Mouse"};
            String[] except = {"Dog", "Cat", "Mouse" };
            ArrayDuplicate duplicate = new ArrayDuplicate();
            String[] result = duplicate.remove(input);
            assertThat(result, arrayContainingInAnyOrder(except));
        }
    }
