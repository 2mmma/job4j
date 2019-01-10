package ru.job4j.loop;



public class Board {

    /**
     * Метод рисует шахматную доску
     * @author tumen.garmazhapov (gtb-85@yandex.ru)
     * @param height высота доски
     * @param width ширина доски
     * @return screen.toString()
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                // условие проверки цветности клетки
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}