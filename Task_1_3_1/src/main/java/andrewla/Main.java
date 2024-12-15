package andrewla;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static int[] findSubstrings(String substring, String filepath) throws IOException {
        BufferedFile file = new BufferedFile(Path.of(filepath), substring.length());
        ArrayList<Integer> indicesArray = new ArrayList<>();

        while (file.getUnreadSize() > substring.length()) {
            String buffer = file.getStringFromBuffer();

            if (substring.equals(buffer)) {
                System.out.println("Found!");
                indicesArray.add(file.getOffset() - substring.length());
            }
        }

        int[] indices = new int[indicesArray.size()];

        for (int i = 0; i < indicesArray.size(); i++) {
            indices[i] = indicesArray.get(i);
        }

        file.close();
        return indices;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}