package ru.job4j.analyze;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class AnalyzeTest {
    private final Analyze analyze = new Analyze();

    @Test
    public void whenAddNewUsers() {
        List<Analyze.User> previousList = Arrays.asList(
                new Analyze.User(1, "A"),
                new Analyze.User(2, "B"),
                new Analyze.User(3, "C"));
        List<Analyze.User> currentList = Arrays.asList(
                new Analyze.User(1, "A"),
                new Analyze.User(2, "B"),
                new Analyze.User(3, "C"),
                new Analyze.User(4, "D"),
                new Analyze.User(5, "E"));
        Analyze.Info info = analyze.diff(previousList, currentList);
        assertThat(info.added, is(2));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(0));
    }

    @Test
    public void whenDeleteUser() {
        List<Analyze.User> previousList = Arrays.asList(
                new Analyze.User(1, "A"),
                new Analyze.User(2, "B"),
                new Analyze.User(3, "C"));
        List<Analyze.User> currentList = Arrays.asList(
                new Analyze.User(1, "A"),
                new Analyze.User(2, "B"));
        Analyze.Info info = analyze.diff(previousList, currentList);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(1));
    }

    @Test
    public void whenChangeUsers() {
        List<Analyze.User> previousList = Arrays.asList(
                new Analyze.User(1, "A"),
                new Analyze.User(2, "B"),
                new Analyze.User(3, "C"));
        List<Analyze.User> currentList = Arrays.asList(
                new Analyze.User(1, "A"),
                new Analyze.User(2, "D"),
                new Analyze.User(3, "E"));
        Analyze.Info info = analyze.diff(previousList, currentList);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(2));
        assertThat(info.deleted, is(0));
    }
}
