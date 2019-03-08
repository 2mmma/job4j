package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.*;

/**
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class OperationTest {

    private final Operation operation = new Operation();
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

        assertThat(operation.findByPassport("0987654321").getName(), is("Arsentev Petr"));
    }

    @Test
    public void whenAdd2AccountsForUserThenDelete1() {
        operation.addUser(first);
        operation.addAccountToUser("1234567890", account1);
        operation.addAccountToUser("1234567890", account2);
        assertThat(operation.getUserAccounts("1234567890").size(), is(2));

        operation.deleteAccountFromUser("1234567890", account1);
        assertThat(operation.getUserAccounts("1234567890").size(), is(1));
        assertThat(operation.getUserAccounts("1234567890"), is(Collections.singletonList(account2)));

    }

    @Test
    public void whenFirstUserTransferMoneyToSecond() {
        operation.addUser(first);
        operation.addUser(second);
        operation.addAccountToUser("1234567890", account1);
        operation.addAccountToUser("0987654321", account2);
        assertTrue(operation.transferMoney("1234567890","11223344",
                "0987654321", "99887766", 500));
        assertThat(operation.getActualAccount("0987654321", "99887766").getValue(), is(3000.0));

        assertFalse(operation.transferMoney("1234567890","11223344",
                "0987654321", "99887766", 1500));

    }
}
