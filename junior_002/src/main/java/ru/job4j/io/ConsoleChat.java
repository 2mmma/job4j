package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author tumen.garmazhapov (mailto:gtb-85@yandex.ru)
 * @since 07.2019
 */
public class ConsoleChat {

    /**
     * text file path
     */
    private final String path;

    /**
     * log file path
     */
    private final String logPath;

    /***
     * storage for strings
     */
    private List<String> list = new ArrayList<>();

    /**
     * storage for log
     */
    private final List<String> logList = new ArrayList<>();

    /**
     * constructor to create an object of this class
     *
     * @param path    text file path
     * @param logPath log file path
     */
    public ConsoleChat(String path, String logPath) {
        this.path = path;
        this.logPath = logPath;
    }

    /**
     * method reads the arguments
     * entered by the user and writes them to logList
     *
     * @return entered string
     */
    public String input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        logList.add("in:  " + input + "\n");
        return input;
    }

    /**
     * method prints a random strings and writes them to logList
     */
    public void output() {
        String output = getString();
        System.out.println(output);
        logList.add("out: " + output + "\n");
    }

    /**
     * method reads lines from text file and writes them to list
     */
    public void getStrings() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            list = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method return random string from list
     *
     * @return string
     */
    public String getString() {
        return list.get(new Random().nextInt(list.size() - 1));
    }

    /**
     * method writes chat log to text file
     */
    public void log() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logPath))) {
            for (String string : logList) {
                bw.write(string);
                bw.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * method builds chat logic:
     * user enters a word-phrase, the program takes a random phrase from a text file
     * and displays it in response. The program becomes silent if the user enters the word "STOP",
     * while he can continue to send messages to chat.
     * If the user enters the word “OK”, the program starts to respond again.
     * When you enter the word “EXIT”, the program stops working.
     */
    public void init() {
        String in = input();
        if (in.contains("STOP")) {
            String s = input();
            while (!s.contains("OK")) {
                if (s.contains("EXIT")) {
                    log();
                    System.out.println("THE END");
                    System.exit(0);
                } else {
                    s = input();
                }
            }
            output();
            init();
        }
        if (in.contains("EXIT")) {
            log();
            System.out.println("THE END");
            System.exit(0);
        } else {
            output();
            init();
        }
    }

    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat("./junior_002/data/consoleChat.txt", "./junior_002/data/log.txt");
        chat.getStrings();
        chat.init();
    }
}