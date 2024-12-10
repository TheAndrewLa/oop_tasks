import andrewla.Pair;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is used to test helper Pair class.
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
        Pair<String, String> anotherPair = new Pair<>("First", "second");

        assertNotEquals(pair, anotherPair);

        pair = new Pair<>("First", "second");
        assertEquals(pair, anotherPair);
    }

    @Test
    void pickTest() {
        Pair<String, String> pair1 = new Pair<>("Hello", "World");
        assertEquals("Hello", pair1.first());
        assertEquals("World", pair1.second());

        Pair<Integer, Integer> pair2 = new Pair<>(1200, -2334);
        assertEquals(1200, pair2.first());
        assertEquals(-2334, pair2.second());
    }
}
