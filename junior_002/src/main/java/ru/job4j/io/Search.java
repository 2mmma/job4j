package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author tumen.garmazhapov (mailto:gtb-85@yandex.ru)
 * @since 06.2019
 */
public class Search {

    /***
     * method returns list of file paths only by a specific predicate
     *
     * @param root directory to be bypassed
     * @param ext String predicate
     * @return file path list
     * @throws IOException exception
     */
    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searchFiles = new SearchFiles((p -> p.toFile().getName().endsWith(ext)));
        Files.walkFileTree(root, searchFiles);
        return searchFiles.getPaths();
    }
}
