package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * В данном классе реализован пример работы со Stream API
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class StreamUsage {

    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent
                    + '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );

        //список tasks фильтруется с помощью лямбда-выражения
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

        //список tasks преобразуется в интерфейс map
        List<String> names = tasks.stream().map(
                task -> task.name
        ).collect(Collectors.toList());
        names.forEach(System.out::println);

        //общее время потраченное на все задачи
        long total = tasks.stream().map(
                task -> task.spent
        ).reduce(0L, Long::sum);
        System.out.println(total);
    }
}
