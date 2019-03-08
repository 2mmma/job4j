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
     * @param account - новый счет пользователя
     */
    public void addAccountToUser(String passport, Account account) {
        User byPassport = findByPassport(passport);
        if (byPassport != null) {
            List<Account> list = this.users.get(byPassport);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
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
     * @return список счетов пользователя
     */
    public List<Account> getUserAccounts(String passport) {
        return this.users.get(findByPassport(passport));
    }

    /**
     * метод переводит деньги с одного счета на другой
     * @param srcPassport - паспорт пользователя(отправитель)
     * @param srcRequisite - счет пользователя(отправитель)
     * @param destPassport - паспорт пользователя(получатель)
     * @param destRequisite - счет пользователя(получатель)
     * @param amount - сумма перевода
     * @return true или false*/
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String destRequisite, double amount) {
        boolean result = false;
        if (srcPassport != null && srcRequisite != null
                && destPassport != null && destRequisite != null && amount > 0) {

            final Account actualAccount = getActualAccount(srcPassport, srcRequisite);
            final Account actualAccount1 = getActualAccount(destPassport, destRequisite);

            if (actualAccount != null && actualAccount1 != null) {
                actualAccount.transfer(
                        actualAccount1, amount);
            }
            result = true;
        }
        return result;
    }

    /**
     * метод возвращает нужный счет пользователя
     * @param passport - паспорт пользователя
     * @param requisite - реквизиты счета пользователя
     * @return acc - выбранный счет пользователя
     */
    public Account getActualAccount(String passport, String requisite) {
        Account acc = null;
        User byPassport = findByPassport(passport);
        if (byPassport != null && requisite != null) {
            List<Account> list = this.users.get(byPassport);
            for (Account account : list) {
                if (account.getRequisites().equals(requisite)) {
                    acc = account;
                    break;
                }
            }
        }
        return acc;
    }

    /**
     * метод возвращает список всех пользователей
     * @return Map - коллекция всех пользователей со счетами
     */
    public Map<User, List<Account>> getUsers() {
        return users;
    }

    /**
     * находит нужного пользователя по паспорту
     * @param passport - паспорт для поиска пользователя
     * @return user - нужный пользователь
     */
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
