package ru.job4j.sort;

import java.util.Arrays;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 11.2019
 */
public class Machine {

    private static final int[] COINS = {10, 5, 2, 1};

    /**
     * метод отсчитывает сдачу исходя от депозита и стоимости товара
     * @param money - внесенная сумма
     * @param price - стоимость
     * @return rsl - "массив" монет
     */
    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int change = money - price;
        for (int coin : COINS) {
            while (change >= coin) {
                change = change - coin;
                rsl[size++] = coin;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
