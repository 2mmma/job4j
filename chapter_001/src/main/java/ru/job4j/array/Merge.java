package ru.job4j.array;

import java.util.Arrays;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 10.2019
 */
public class Merge {

    /**
     * метод принимает два отсортированных массива
     * и объединяет их в один
     *
     * @param left  - первый массив;
     * @param right - второй массив;
     * @return rsl - новый массив
     */
    public int[] merge(int[] left, int[] right) {

        int[] rsl = new int[left.length + right.length];
        int j = 0;
        int k = 0;
        int i = 0;
        while (i < rsl.length) {

            if (j > left.length - 1) {
                rsl[i] = right[k];
                k++;
            } else if (k > right.length - 1) {
                rsl[i] = left[j];
                j++;

            } else {
                rsl[i] = left[j] < right[k] ? left[j++] : right[k++];
            }
            i++;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
