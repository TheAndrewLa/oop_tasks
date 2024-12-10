package andrewla;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class which provides testing of CardPools logic.
 * Size of pool.
 * Uniqueness of cards in pool.
 */
public class CardsPoolTest {

    @Test
    public void size() {
        assertEquals(52, (new CardPool()).size());
    }

    @Test
    public void uniqueness() {
        CardPool pool = new CardPool();
        HashSet<Card> cards = new HashSet<>();

        for (int i = 0; i < 52; i++) {
            Card card = pool.takeCard(false);

            assertFalse(cards.contains(card));
            cards.add(card);
        }
    }
}
