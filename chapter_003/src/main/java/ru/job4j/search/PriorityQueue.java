package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int size = tasks.size();
        for (int i = 0; i < this.tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                size = i;
                break;
            }
        }
        tasks.add(size, task);
    }
    public Task take() {
        return this.tasks.poll();
    }
    public Task takeLast() {
        return this.tasks.pollLast();
    }

}
