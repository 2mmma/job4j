package ru.job4j.io;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author tumen.garmazhapov (mailto:gtb-85@yandex.ru)
 * @since 07.2019
 */
public class Zip {

    /***
     * method archives all directory files that pass through the filter.
     *
     * @param sources file path list
     * @param target zip-file
     */
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(String.valueOf(path)));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /***
     * method archives single file
     *
     * @param source file for archiving
     * @param target zip-file
     */
    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        new Zip().packSingleFile(
//                new File("./junior_002/data"),
//                new File("./junior_002/data/for.zip")
//        );
        System.out.println("Enter args according to the template:\n "
                + "-d *directory to be bypassed* -e *exclude* -o *where do you archive*");
        Zip zip = new Zip();
        ArgZip argZip = new ArgZip(args);
        List<Path> paths = Search.fileFilter(Paths.get(argZip.directory()), argZip.exclude());
        zip.packFiles(paths, new File(new ArgZip(args).output()));
    }
}
