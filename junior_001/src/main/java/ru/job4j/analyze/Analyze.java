package ru.job4j.analyze;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author tumen.garmazhapov
 * @since 06.2019
 */
public class Analyze {

    /**
     * Метод определяет разницу между двумя списками
     *
     * @param previous начальный список.
     * @param current  измененный список.
     * @return Info итоговые изменения.
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, User> map = new HashMap<>();
        for (User user : current) {
            map.put(user.id, user);
        }
        for (User oldUser : previous) {
            User value = map.putIfAbsent(oldUser.id, oldUser);
            if (value == null) {
                info.deleted++;
            } else if (!value.name.equals(oldUser.name)) {
                info.changed++;
            }
        }
        info.added = current.size() - (previous.size() - info.deleted);
        return info;
    }

    /**
     * Модель User.
     */
    public static class User {
        final int id;
        final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    /**
     * Статистика изменений в списках.
     */
    public static class Info {
        /**
         * Сколько пользователей добавлено.
         */
        int added;
        /**
         * Сколько пользователей изменено(без смены id).
         */
        int changed;
        /**
         * Сколько пользователей удалено.
         */
        int deleted;
    }
}
