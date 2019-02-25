package ru.job4j.comparator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
    Set<User> sort (List<User> users) {
        return new TreeSet<>(users);
    }

}
