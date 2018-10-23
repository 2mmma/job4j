package ru.job4j.converter;

/**
 * Конвертер валюты
 */
public class Converter {

    /**
     * Ковертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return (value / 70);
    }

    /**
     * Ковертируем рубли в доллар.
     * @param value рубли.
     * @return Доллар.
     */
    public int rubleToDollar(int value) {
        return (value / 60);
    }

    /**
     * Ковертируем евро в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public int evroToRuble(int value) {
        return (value * 70);
    }

    /**
     * Ковертируем доллар в рубли.
     * @param value доллар.
     * @return Рубли.
     */
    public int dollarToRuble(int value) {
        return (value * 60);
    }
}
