package ru.job4j.find;

/**
 * @author tumen.garmazhapov (mailto:gtb-85@yandex.ru)
 * @since 07.2019
 */
public class Args {

    /***
     * array for args
     */
    private final String[] args;

    /***
     * constructor to create an object of this class
     *
     * @param args array of entry args
     */
    public Args(String[] args) {
        this.args = args;
    }

    /***
     * method checks introduced args
     *
     * @return true/false
     */
    public boolean valid() {
        return (args.length < 6);
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
        if (valid() && (args[2].equals("-m") || args[2].equals("-f") || args[2].equals("-r"))) {
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

    /***
     * method returns filter for find
     *
     * @return filter
     */
    public FindFiles filter() {
        FindFiles findFiles = null;
        if (valid() && args[2].equals("-m")) {
            findFiles = new FindFiles(p -> p.toFile().getName().startsWith(exclude()));
        } else if (valid() && args[2].equals("-f")) {
            findFiles = new FindFiles(p -> p.toFile().getName().equals(exclude()));
        } else if (valid() && args[2].equals("-r")) {
            findFiles = new FindFiles(p -> p.toFile().getName().endsWith(exclude()));
        }
        return findFiles;
    }
}
