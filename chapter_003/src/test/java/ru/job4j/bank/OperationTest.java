package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class OperationTest {

    private Operation operation = new Operation();
    private final User first = new User("Garmazhapov Tumen", "1234567890");
    private final User second = new User("Arsentev Petr", "0987654321");
    private final Account account1 = new Account(1000, "11223344");
    private final Account account2 = new Account(2500, "99887766");

    @Test
    public void whenAdd2UsersThenDelete1() {
        operation.addUser(first);
        operation.addUser(second);
        Map<User, List<Account>> result = operation.getUsers();
        assertThat(result.size(), is(2));

        operation.deleteUser(first);
        assertThat(result.size(), is(1));
    }

    @Test
    public void whenAdd2AccountsForUserThenDelete1() {
        operation.addUser(first);
        operation.addAccountToUser("1234567890", account1);
        operation.addAccountToUser("1234567890", account2);
        List<Account> result = new ArrayList();
        result = operation.getUserAccounts("1234567890");
        assertThat(result.size(), is(2));
    }
}
