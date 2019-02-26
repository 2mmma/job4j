package ru.job4j.user;

import java.util.HashMap;
import java.util.List;

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
        HashMap<Integer, User> userMap = new HashMap<>();
        for (User user : list) {
            userMap.put(user.getId(), user);
        } return userMap;
    }
}
