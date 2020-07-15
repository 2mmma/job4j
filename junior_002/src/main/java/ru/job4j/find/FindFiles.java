package ru.job4j.find;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * @author tumen.garmazhapov (mailto:gtb-85@yandex.ru)
 * @since 07.2019
 */
public class FindFiles extends SimpleFileVisitor<Path> {

    /**
     * storage for results
     */
    private final List<Path> result = new ArrayList<>();

    /**
     * file type predicate
     */
    private final Predicate<Path> predicate;

    /**
     * constructor to create an object of this class
     *
     * @param predicate predicate
     */
    public FindFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    /**
     * method returns the result
     *
     * @return result
     */
    public List<Path> getPaths() {
        return result;
    }

    /**
     * the overridden method saves the file path in the storage
     * if the file type matches the predicate
     *
     * @param file  file path
     * @param attrs BasicFileAttributes
     * @return result
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (this.predicate.test(file)) {
            result.add(file);
        }
        return CONTINUE;
    }
}


