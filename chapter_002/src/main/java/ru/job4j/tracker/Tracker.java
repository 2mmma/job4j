package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * @author tumen.garmazhapov
 * @since 11.2018
 */

public class Tracker {

    private final List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     * @return item - добавленная заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(RN.nextInt(100));
    }


    /**
     * редактирование заявок
     * @param id ключ
     * @param item заявка
     * @return true/false
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            Predicate<Item> predicate = item1 -> item1.getId().equals(id);
            if (predicate.test(items.get(i))) {
                items.set(i, item);
                item.setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * удаление заявок
     * @param id - ключ заявки удаляемой заявки
     * @return true/false
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * получение списка всех заявок
     * @return  items - все заявки
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * получение списка по имени
     * @param key ключ
     * @return result - найденная(ые) заявка(и)
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        Predicate<Item> predicate = item -> item.getName().equals(key);
        for (Item item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }


    /**получение заявки по id
     * @param id ключ
     * @return result - найденная заявка
     */
    public Item findById(String id) {
        Item result = null;
        Predicate<Item> predicate = item -> item.getId().equals(id);
            for (Item item : items) {
                if (predicate.test(item)) {
                    result = item;
                }
            }
            return result;
    }
}