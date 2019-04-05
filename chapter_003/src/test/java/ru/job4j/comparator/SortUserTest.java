package ru.job4j.comparator;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenListUsersSortedByAgeReturnTreeSet() {
        SortUser sortUser = new SortUser();

        List<User> users = List.of(
                new User("Jack", 55),
                new User("Ivan", 35),
                new User("Petr", 40));

        List<User> except = List.of(
                new User("Ivan", 35),
                new User("Petr", 40),
                new User("Jack", 55));

        Set<User> userSet = sortUser.sort(users);
        assertThat(userSet.toString(), is(except.toString()));
    }

    @Test
    public void whenListUsersSortedByNameLengthReturnList() {
        SortUser sortUser = new SortUser();

        List<User> users = List.of(
                new User("Jack", 55),
                new User("Ivan", 35),
                new User("Petrov", 40),
                new User("Bob", 15));

        List<User> except = List.of(
                new User("Bob", 15),
                new User("Jack", 55),
                new User("Ivan", 35),
                new User("Petrov", 40));

        List<User> userSet = sortUser.sortNameLength(users);
        assertThat(userSet.toString(), is(except.toString()));
    }

    @Test
    public void whenListUsersSortedByNameAndAgeReturnList() {
        SortUser sortUser = new SortUser();

        List<User> users = List.of(
                new User("Jack", 55),
                new User("Ivan", 35),
                new User("Bob", 20),
                new User("Petrov", 40),
                new User("Bob", 15),
                new User("Ivan", 18));

        List<User> except = List.of(
                new User("Bob", 15),
                new User("Bob", 20),
                new User("Ivan", 18),
                new User("Ivan", 35),
                new User("Jack", 55),
                new User("Petrov", 40));

        List<User> userSet = sortUser.sortByAllFields(users);
        assertThat(userSet.toString(), is(except.toString()));
    }
}
