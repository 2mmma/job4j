package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 06.2019
 */
public class Config {

    /**
     * Хеш-карта для хранения загруженных данных
     */
    private final Map<String, String> values = new HashMap<>();

    /**
     * полный путь к файлу
     */
    private final String path;

    /**
     * конструктор для создания объекта класса Config,
     * в который передается путь к файлу
     *
     * @param path - путь к файлу
     */
    public Config(final String path) {
        this.path = path;
    }

    /**
     * метод для парсинга конфигураций
     */
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines().filter(str -> !str.startsWith("#") && str.contains("="))
                    .map(str -> str.split("="))
                    .filter(str -> str.length == 2)
                    .forEach(str -> values.put(str[0].trim(), str[1].trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод возвращает значение по ключу
     *
     * @param key - ключ
     * @return - значение, соответствующее ключу
     */
    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
