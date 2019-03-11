package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса Calculator
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class UserConvertTest {

    @Test
    public  void whenAdd3NewUsers() {
        UserConvert toUser = new UserConvert();
        List<String> names = Arrays.asList("Scott", "Donald", "Jack");
        List<UserConvert.User> users = toUser.convert(names, UserConvert.User::new);
        assertThat(equals(users), is(equals("User{name='Scott'}, User{name='Donald'}, User{name='Jack'}")));
    }
}
