package ru.job4j.comparator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenListUsersSortedByAgeReturnTreeSet() {
        SortUser sortUser = new SortUser();

        List<User> users = new ArrayList<>();
        users.add(new User("Jack", 55));
        users.add(new User("Ivan", 35));
        users.add(new User("Petr", 40));

        List<User> except = new ArrayList<>();
        except.add(new User( "Ivan", 35));
        except.add(new User("Petr", 40));
        except.add(new User("Jack", 55));

        Set<User> userSet = sortUser.sort(users);
        assertThat(userSet.toString(),is(except.toString()));
    }
}
