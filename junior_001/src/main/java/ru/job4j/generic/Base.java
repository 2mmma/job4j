package ru.job4j.generic;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 02.2020
 */
public abstract class Base {

    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
