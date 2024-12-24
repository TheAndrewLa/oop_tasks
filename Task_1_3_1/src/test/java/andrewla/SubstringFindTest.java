package andrewla;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class provides testing functions for SubstringFind class.
 */
public class SubstringFindTest {

    static private Writer writer;
    static private String fileName;

    private static void createFile(String name) throws IOException {
        fileName = name;

        Files.createFile(Path.of(fileName));

        try {
            writer = new OutputStreamWriter(new FileOutputStream(name), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Bad name of file!");
        }
    }

    private static void deleteFile() throws IOException {
        writer.close();
        Files.deleteIfExists(Path.of(fileName));
    }

    private static void writeFile(String pattern) throws IOException {
        writer.write(pattern);
        writer.flush();
    }

    private static void writeFileMultiple(String pattern, int times) throws IOException {
        for (int i = 0; i < times; i++) {
            writer.write(pattern);
        }

        writer.flush();
    }

    @Test
    void test1() throws IOException {
        createFile("test1.txt");

        writeFile("HelloWorld");
        writeFileMultiple("Привет", 3);
        writeFileMultiple("Goodbye", 5);
        writeFileMultiple("Привет", 5);
        writeFile("He-he");

        int[] actual = SubstringFind.findAll("Привет", "test1.txt");
        int[] expected = {10, 16, 22, 63, 69, 75, 81, 87};

        assertArrayEquals(expected, actual);

        deleteFile();
    }

    @Test
    void test2() throws IOException {
        createFile("test2.txt");

        writeFileMultiple("Black", 13224);
        writeFileMultiple("WhiteBlack", 2313);

        int[] actual = SubstringFind.findAll("Black", "test2.txt");

        assertEquals(17850, actual.length);

        deleteFile();
    }

    @Test
    void test3() throws IOException {
        createFile("test3.txt");

        writeFile("SysPro");
        writeFileMultiple("FIT", 123);
        writeFile("SysPro");

        int[] actual = SubstringFind.findAll("SysPro", "test3.txt");
        int[] expected = {0, 6 + 3 * 123};

        assertArrayEquals(expected, actual);

        deleteFile();
    }

    @Test
    void test4() throws IOException {
        createFile("test4.txt");

        int[] actual = SubstringFind.findAll("EmptyFile", "test4.txt");
        int[] expected = {};

        assertArrayEquals(expected, actual);

        deleteFile();
    }
}
