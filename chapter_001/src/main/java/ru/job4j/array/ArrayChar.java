package ru.job4j.array;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 10.2018
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i <= value.length - 1; i++) {
            if (value[i] != data[i]) {
                result = false;
            }
        }
        return result;
    }
}