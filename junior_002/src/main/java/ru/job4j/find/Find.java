package ru.job4j.find;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author tumen.garmazhapov (mailto:gtb-85@yandex.ru)
 * @since 07.2019
 */
public class Find {

    /***
     * method returns list of file paths only by a specific predicate
     *
     * @param root directory to be bypassed
     * @return file path list
     * @throws IOException exception
     */
    public static List<Path> search(Path root, Args args) throws IOException {
        FindFiles findFiles = args.filter();
        Files.walkFileTree(root, findFiles);
        return findFiles.getPaths();
    }

    /**
     * method writes result to text file
     *
     * @param output text file
     * @param paths  paths list
     */
    public static void write(String output, List<Path> paths) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            for (Path path : paths) {
                bw.write(String.valueOf(path + "\n"));
                bw.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter args according to the template:\n "
                + "-d *directory to be bypassed* -m/-f/-r *exclude startWith/equals/endsWith * -o *file to log*");
        Args arg = new Args(args);
        List<Path> result = search(Paths.get(arg.directory()), arg);
        write(arg.output(), result);
    }
}
