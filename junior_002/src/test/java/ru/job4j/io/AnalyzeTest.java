package ru.job4j.io;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;


public class AnalyzeTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenUnavailableTest() throws IOException {
        String source = "./data/forAnalyzeSource";
        String target = "./data/forAnalyzeTarget";
        Analyze analyze = new Analyze();
        analyze.unavailable(source, target);
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            assertThat(reader.readLine(), is("10:58:01;10:59:01"));
            assertThat(reader.readLine(), is("11:01:02;11:02:02"));
            assertThat(reader.readLine(), is("11:05:02;11:15:02"));
            assertNull(reader.readLine());
        }
    }

    @Test
    public void whenTemporaryFilesTest() throws IOException {
        Analyze analyze = new Analyze();
        File source = folder.newFile("sourceTemporary.txt");
        File target = folder.newFile("targetTemporary.txt");
        try (FileWriter writer = new FileWriter(source.getAbsolutePath())) {
            String text = "server.log\n"
                    + "200 10:56:01\n"
                    + "200 10:57:01\n"
                    + "400 10:58:01\n"
                    + "200 10:59:01";
            writer.write(text);
            writer.append("\n");
            writer.append("E");
            writer.flush();
            analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
            try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
                assertThat(reader.readLine(), is("10:58:01;10:59:01"));
            }
        }
    }
}
