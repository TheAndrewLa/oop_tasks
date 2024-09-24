package andrewla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class which provides testing of Cards logic.
 * Constructor with an error.
 * toString methods in different situations.
 * Rank of card in different situations.
 */
public class CardsTest {

    @Test
    public void constructor() {
        try {
            new Card(-100, CardSuit.Hearts);
            assertTrue(false);
        } catch (AssertionError error) {
            assertTrue(true);
        }
    }

    @Test
    public void string() {
        String str = (new Card(5, CardSuit.Hearts)).toString();
        assertEquals("Пятерка Червы", str);

        str = (new Card(10, CardSuit.Spades)).toString();
        assertEquals("Десятка Пики", str);

        str = (new Card(CardType.Ace, CardSuit.Diamonds)).toString();
        assertEquals("Туз Бубы", str);

        str = (new Card(CardType.King, CardSuit.Clubs)).toString();
        assertEquals("Король Трефы", str);
    }

    @Test
    public void stringHiddenCard() {
        Card card = new Card(CardType.Ace, CardSuit.Clubs);
        card.hide();

        assertEquals("<скрытая карта>", card.toString());
    }

    @Test
    public void ranks() {
        int rank = (new Card(CardType.Ace, CardSuit.Diamonds)).getRank();
        assertEquals(0, rank);

        rank = (new Card(2, CardSuit.Spades)).getRank();
        assertEquals(2, rank);

        rank = (new Card(CardType.Queen, CardSuit.Hearts)).getRank();
        assertEquals(0, rank);

        rank = (new Card(7, CardSuit.Clubs)).getRank();
        assertEquals(7, rank);
    }
}
