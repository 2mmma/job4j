package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class UserConvert {

    /**
     * класс пользователя User
     */
    public static class User {

        private final String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='"
                    + name + '\''
                    + '}';
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
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    /**
     * метод преобразует список имен в новые объекты класса User
     * @param names - список имен
     * @param op  - интерфейс
     * @return users - список новых пользователей
     */
    public List<User> convert(List<String> names, Function<String, User> op) {
        List<User> users = new ArrayList<>();
        final StringBuilder last = new StringBuilder();
        names.forEach(
                n ->  {
                    last.ensureCapacity(0);
                    last.append(n);
                }
        );
        return users;
    }

    public static void badMethod() throws Exception {
    }

    public static interface Wrapper<T> {
        T get();
        void set(T value);
        boolean isEmpty();
    }

    public static void main(String[] args) throws Exception {
        List<String> names = Arrays.asList("Petr", "Nick", "Ban");
        Wrapper<Exception> ex = null;
        names.forEach(
                n ->  {
                    try {
                        badMethod();
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        if (ex != null && !ex.isEmpty()) {
            throw ex.get();
        }
    }
}
