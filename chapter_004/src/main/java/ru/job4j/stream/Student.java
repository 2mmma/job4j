package ru.job4j.stream;

import java.util.Comparator;

/**
 * @author tumen.garmazhapov
 * @since 04.2019
 */
public class Student implements Comparator<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public String toString() {
        return String.format("%s : %d", this.name, this.score);
    }
}
