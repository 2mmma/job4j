package ru.job4j.bank;

import java.util.*;

/**
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class Operation {

    /**
     * хранилище данных
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляет нового пользователя
     * @param user - пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод удаляет пользователя
     * @param user - пользователь
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * метод добавляет счет пользователю
     * @param passport - паспорт пользователя
     * @param account - счет пользователя
     */
    public void addAccountToUser(String passport, Account account) {
        users.get(findByPassport(passport)).add(account);
    }


    /**
     * метод удаляет счет пользователя
     * @param passport - паспорт пользователя
     * @param account - счет(а) пользователя
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> userAccounts = users.get(findByPassport(passport));
        userAccounts.remove(account);
    }

    /**
     * метод возвращает список счетов пользователя
     * @param passport - паспорт пользователя
     * @return - список счетов пользователя
     */
    public List<Account> getUserAccounts(String passport) {
        return users.get(passport);
    }

    /**
     * метод переводит деньги с одного счета на другой
     * @param srcPassport - паспорт пользователя(отправитель)
     * @param srcRequisite - счет пользователя(отправитель)
     * @param destPassport - паспорт пользователя(получатель)
     * @param destRequisite - счет пользователя(получатель)
     * @param amount - сумма перевода
     * @return true или false*/
    public boolean transferMoney(String srcPassport, Account srcRequisite,
                                  String destPassport, Account destRequisite, double amount) {
        return getActualAccount(srcPassport, srcRequisite).transfer(
                getActualAccount(destPassport, destRequisite), amount);
    }

    /**
     * метод возвращает пользователя и счет
     * @param passport - паспорт пользователя
     * @param account - счет пользователя
     * @return выбранный счет пользователя*/
    private Account getActualAccount(String passport, Account account) {
        List<Account> list = this.users.get(passport);
        return list.get(list.indexOf(account));
    }

    public Map<User, List<Account>> getUsers() {
        return users;
    }

    public User findByPassport(String passport) {
        User user = null;

        for (User temp : users.keySet()) {
            if (temp.getPassport().equals(passport)) {
                user = temp;
                break;
            }
        }
        return user;
    }
}
