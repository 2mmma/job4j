package io;

import java.io.FileInputStream;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 06.2020
 */
public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            text.delete(0, text.length());
            for (String line : lines) {
                String result = Integer.parseInt(line) % 2 == 0 ? " is even" : " is not even";
                System.out.println(line + result);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}