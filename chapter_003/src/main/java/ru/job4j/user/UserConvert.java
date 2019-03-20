package ru.job4j.user;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tumen.garmazhapov
 * @since 02.2019
 */
public class UserConvert {

    /**
     * метод конвертирует список List в интерфейс Map.
     * @param list - список.
     * @return userMap.
     */
    public HashMap<Integer, User> process(List<User> list) {
        return list.stream().collect(
                Collectors.toMap(User::getId, user -> user, (a, b) -> a, HashMap::new));
    }
}
