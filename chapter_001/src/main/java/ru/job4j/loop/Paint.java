package ru.job4j.loop;

/**
 * Программа рисует пирамиду на псевдографике
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 10.2018
 */
public class Paint {

    /**
     * @param height высота пирамиды.
     * @return screen.toString();
     */
    public String pyramid(int height) {
        // Буфер для результата.
        StringBuilder screen = new StringBuilder();
        // ширина будет равна высоте.
        int weight = 2 * height - 1 ;
        // внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            // внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            // перевод строки.
            screen.append(System.lineSeparator());
        }
        //  результат.
        return screen.toString();
    }
}