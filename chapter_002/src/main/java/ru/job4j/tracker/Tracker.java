package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @author tumen.garmazhapov
 * @since 11.2018
 */

public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }


    /**редактирование заявок
     *
     * @param id
     * @param item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (item != null && items[i].getId().equals(id)) {
                items[i] = item;
                item.setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * удаление заявок
     */
    public boolean delete(String id) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = items[count];
                System.arraycopy(this.items, i + 1, this.items, i, items.length - i - 1);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * получение списка всех заявок
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**получение списка по имени
     *
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        int count = 0;
        Item[] result = new Item[position];
        for (int i = 0; i < result.length; i++) {
            if (items[i].getName().equals(key)) {
                result[count++] = items[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**получение заявки по id
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}