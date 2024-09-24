package andrewla;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void cardTest1() {
        try {
            new Card(-100, CardSuit.Hearts);
            assertTrue(false);
        } catch (AssertionError error) {
            assertTrue(true);
        }
    }

    @Test
    public void cardTest2() {
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
    public void cardTest3() {
        Card card = new Card(CardType.Ace, CardSuit.Clubs);
        card.hide();

        assertEquals("<скрытая карта>", card.toString());
    }

    @Test
    public void cardTest4() {
        int rank = (new Card(CardType.Ace, CardSuit.Diamonds)).getRank();
        assertEquals(0, rank);

        rank = (new Card(2, CardSuit.Spades)).getRank();
        assertEquals(2, rank);

        rank = (new Card(CardType.Queen, CardSuit.Hearts)).getRank();
        assertEquals(0, rank);

        rank = (new Card(7, CardSuit.Clubs)).getRank();
        assertEquals(7, rank);
    }

    @Test
    public void cardPoolTest1() {
        assertEquals(52, (new CardPool()).size());
    }

    @Test
    public void cardPoolTest2() {
        CardPool pool = new CardPool();
        HashSet<Card> cards = new HashSet<>();

        for (int i = 0; i < 52; i++) {
            Card card = pool.takeCard(false);

            assertFalse(cards.contains(card));
            cards.add(card);
        }
    }

    @Test
    public void handTest1() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardType.Queen, CardSuit.Spades));
        hand.addCard(new Card(3, CardSuit.Hearts));
        hand.addCard(new Card(7, CardSuit.Spades));

        String expected = "[Дама Пики (10); Тройка Червы (3); Семерка Пики (7)] => 20";

        assertEquals(expected, hand.toString());
    }

    @Test
    public void handTest2() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardType.Ace, CardSuit.Clubs));
        hand.addCard(new Card(7, CardSuit.Diamonds));

        hand.getCard(1).hide();

        String expected = "[Туз Трефы (11); <скрытая карта>]";

        assertEquals(expected, hand.toString());
    }
}
