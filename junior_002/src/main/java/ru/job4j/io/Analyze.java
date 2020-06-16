package ru.job4j.io;

import java.io.*;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 06.2019
 */
public class Analyze {

    /**
     * метод анализирует лог событий сервера
     * записывает периоды времени в другой файл,
     * когда сервер был недоступен
     *
     * @param source файл лога событий сервера
     * @param target файл для записи данных
     */
    public void unavailable(String source, String target) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String str = reader.readLine();
            boolean cursor = true;
            String date = "";
            while (str != null) {
                if (cursor && (str.startsWith("400") || str.startsWith("500"))) {
                    date = str.substring(4);
                    cursor = false;
                }
                if (!cursor && (str.startsWith("200") || str.startsWith("300"))) {
                    result.append(date.strip()).
                            append(";").
                            append(str.substring(4).strip()).
                            append(System.lineSeparator());
                    cursor = true;
                }
                str = reader.readLine();
            }
            writer.write(result.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
