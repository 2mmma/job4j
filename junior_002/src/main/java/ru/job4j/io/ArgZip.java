package ru.job4j.io;

/**
 * @author tumen.garmazhapov (mailto:gtb-85@yandex.ru)
 * @since 07.2019
 */
public class ArgZip {

    /***
     * array for args
     */
    private final String[] args;

    /***
     * constructor to create an object of this class
     *
     * @param args array of entry args
     */
    public ArgZip(String[] args) {
        this.args = args;
    }

    /***
     * method checks introduced args
     *
     * @return true/false
     */
    public boolean valid() {
        if (args.length < 6) {
            throw new IllegalArgumentException("Wrong arguments. Enter data according to the template.");
        }
        return true;
    }

    /***
     * method returns introduced value for argument
     *
     * @return received value
     */
    public String directory() {
        if (valid() && args[0].contains("-d")) {
            return args[1];
        }
        return "";
    }

    /***
     * method returns introduced value for argument
     *
     * @return received value
     */
    public String exclude() {
        if (valid() && args[2].equals("-e")) {
            return args[3];
        }
        return "";
    }

    /***
     * method returns introduced value for argument
     *
     * @return received value
     */
    public String output() {
        if (valid() && args[4].equals("-o")) {
            return args[5];
        }
        return "";
    }
}
