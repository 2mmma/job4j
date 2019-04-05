package ru.job4j.stream;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tumen.garmazhapov
 * @since 04.2019
 */
public class SortStudentTest {

    @Test
    public void whenAddSomeStudentsThanSortThem() {
        SortStudent sort = new SortStudent();
        Student first = new Student("Tommy", 4);
        Student second = new Student("Jane", 3);
        Student third = new Student("Bill", 4);
        Student fourth = new Student("Kate", 5);
        Student fifth = new Student("Scott", 2);
        List<Student> students = new ArrayList<>(Arrays.asList(first, second, null, third, null, fourth, fifth));
        List<Student> result = sort.levelOf(students, 3);
        List<Student> except = new ArrayList<>(Arrays.asList(fourth, first, third));
        assertThat(result, is(except));
    }
}
