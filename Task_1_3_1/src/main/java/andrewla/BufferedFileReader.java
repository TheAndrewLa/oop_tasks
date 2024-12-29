package andrewla;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

/**
 * A class which provides functions to work with file using bufferization.
 */
public class BufferedFileReader implements AutoCloseable {

    private final char[] buffer;
    private final int halfSize;
    private int actualSize;

    private final InputStreamReader reader;

    private boolean pre_invalid = false;
    private boolean invalid = false;

    /**
     * Constructor of BufferedFileReader. Size of buffer is two times bigger than parameter in
     * constructor.
     *
     * @param path       a path to file
     * @param targetSize a size of buffer
     * @throws IOException when IO exception occurs
     */
    BufferedFileReader(Path path, int targetSize) throws IOException {
        try {
            reader = new InputStreamReader(new FileInputStream(path.toFile()),
                StandardCharsets.UTF_8);
        } catch (FileNotFoundException exception) {
            throw new IllegalArgumentException("File not exist!");
        }

        halfSize = targetSize;
        int bufferSize = halfSize * 2;

        buffer = new char[bufferSize];

        actualSize = fillBuffer(0, bufferSize);

        if (actualSize == 0) {
            pre_invalid = true;
            invalid = true;
        }
    }

    /**
     * Functions which fills internal buffer with content of a file.
     *
     * @throws IOException when IO error occurs
     */
    public void updateBuffer() throws IOException {

        // Shifting buffer

        for (int i = 0; i < halfSize; i++) {
            buffer[i] = buffer[i + halfSize];
        }

        // Updating buffer & updating size

        actualSize = halfSize + fillBuffer(halfSize, halfSize);
    }

    /**
     * Function which compare internal buffer with given String.
     *
     * @param string a string to compare
     * @return index of first occurrence of sting in buffer
     */
    public int findString(String string) {

        // Propagating state of buffer
        invalid = pre_invalid;

        int sizeToCompare = Math.min(actualSize, buffer.length);

        for (int i = 0; i < sizeToCompare - string.length() + 1; i++) {
            boolean equal = true;

            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) != buffer[i + j]) {
                    equal = false;
                    break;
                }
            }

            if (equal) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns status of a buffer. Invalid buffer means there's no data left.
     *
     * @return a status of a buffer
     */
    public boolean isValid() {
        return !invalid;
    }

    /**
     * Function which encapsulates read function.
     *
     * @param offset an offset in buffer where to write
     * @param size a number of bytes to be tried to read
     * @return number of read bytes or 0 if EOF has been reached
     * @throws IOException when IO error occurred
     */
    private int fillBuffer(int offset, int size) throws IOException {
        int loaded = Math.max(0, reader.read(buffer, offset, size));

        if (loaded == 0) {
            pre_invalid = true;
        }

        return loaded;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
