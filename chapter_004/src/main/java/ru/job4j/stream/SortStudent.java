package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tumen.garmazhapov
 * @since 04.2019
 */
public class SortStudent {

    /**
     * метод принимает список студентов,
     * выбирает из этого списка студентов с показателем выше bound
     *
     * @param students - список студентов
     * @param bound    - уровень отбора
     * @return - новый список
     */
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}
