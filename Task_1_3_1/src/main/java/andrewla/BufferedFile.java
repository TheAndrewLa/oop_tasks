package andrewla;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferedFile {

    private final byte[] buffer;
    private int offset = 0;
    private final long totalSize;

    private final FileInputStream stream;

    BufferedFile(Path path, int bufferSize) throws IOException {
        buffer = new byte[bufferSize];

        try {
            stream = new FileInputStream(path.toFile());
            totalSize = Files.size(path);
        } catch (FileNotFoundException exception) {
            // Is it needed here and below?
            // exception.printStackTrace();
            throw new IllegalArgumentException("File not exist!");
        }
    }

    private void fillBuffer() throws IOException {
        int total = stream.readNBytes(buffer, offset, buffer.length);
        offset += total;

        // If buffer size is bigger than was read
        for (int i = total; i < buffer.length; i++) {
            buffer[i] = 0;
        }
    }

    public long getSize() {
        return totalSize;
    }

    public long getUnreadSize() {
        return totalSize - (long) offset;
    }

    public int getOffset() {
        return offset;
    }

    public String getStringFromBuffer() throws IOException {
        fillBuffer();
        return new String(buffer, 0, buffer.length, StandardCharsets.UTF_8);
    }

    public void close() {
        try {
            stream.close();
        } catch (IOException exception) {
            System.out.println("Something went wrong!");

            // Is it needed?
            // exception.printStackTrace();
        }
    }
}
