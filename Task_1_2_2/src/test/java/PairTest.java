import andrewla.Pair;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is used to test helper Pair class
 */
public class PairTest {

    @Test
    void updateTest() {
        Pair<String, Integer> pair = new Pair<>("Int", 120);
        assertEquals("(Int; 120)", pair.toString());

        pair.update("He-he", 130);
        assertEquals("(He-he; 130)", pair.toString());
    }

    @Test
    void equalTest() {
        Pair<String, String> pair = new Pair<>("First", "Second");
        Pair<String, String> another_pair = new Pair<>("First", "second");

        assertNotEquals(pair, another_pair);

        pair = new Pair<>("First", "second");
        assertEquals(pair, another_pair);
    }
}
