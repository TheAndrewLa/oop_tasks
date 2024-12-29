package andrewla;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Class provides functions to find substring
 */
public class SubstringFind {

    /**
     * Functions try to find all substrings in file.
     *
     * @param substring a substring to fund
     * @param filepath  a path to file where find substring
     * @return an array of indices
     * @throws IOException when IO error occurs
     */
    public static int[] findAll(String substring, String filepath) throws IOException {
        ArrayList<Integer> indicesArray = new ArrayList<>();

        try (var reader = new BufferedFileReader(Path.of(filepath), substring.length())) {
            int globalOffset = 0;

            while (reader.isValid()) {
                int found = reader.findString(substring);

                if (found != -1) {
                    indicesArray.add(found + globalOffset);
                }

                reader.updateBuffer();
                globalOffset += substring.length();
            }
        }

        int[] indices = new int[indicesArray.size()];

        for (int i = 0; i < indices.length; i++) {
            indices[i] = indicesArray.get(i);
        }

        return indices;
    }
}
