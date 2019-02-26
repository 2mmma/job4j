package ru.job4j.comparator;

import java.util.*;

/**
 * @author tumen.garmazhapov
 * @since 02.2019
 */
public class SortUser {

    /**
     * метод принимает List и возвращает TreeSet пользователей,
     * отсортированных по возрасту в порядке возрастания.
     * @param users - список пользователей
     * @return userSet
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    public List<User> sortNameLength(List<User> users) {

        users.sort(new Comparator<User>() {
            public int compare(User a, User b) {
                return a.getName().length() - b.getName().length();
            }
        });
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {

        users.sort(new Comparator<User>() {
            public int compare(User user1, User user2) {
                int result = user1.getName().compareTo(user2.getName());
                if (result == 0) {
                    result = Integer.compare(user1.getAge(), user2.getAge());
                }
                return result;
            }
        });
        return users;
    }

}
