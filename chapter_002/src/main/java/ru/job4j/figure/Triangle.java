package ru.job4j.figure;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 01.2019
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append("  + +  ");
        pic.append(" +   + ");
        pic.append("+++++++");
        return pic.toString();
    }
}
