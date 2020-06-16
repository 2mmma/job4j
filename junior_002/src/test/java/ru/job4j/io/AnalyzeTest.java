package ru.job4j.io;


import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;


public class AnalyzeTest {

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
}
