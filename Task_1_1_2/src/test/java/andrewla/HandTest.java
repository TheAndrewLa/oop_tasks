package andrewla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class which provides testing of Hands logic. toString method in different situations. Value
 * of hand in different situations.
 */
public class HandTest {

    @Test
    public void string() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardType.Queen, CardSuit.Spades));
        hand.addCard(new Card(3, CardSuit.Hearts));
        hand.addCard(new Card(7, CardSuit.Spades));

        String expected = "[Дама Пики (10); Тройка Червы (3); Семерка Пики (7)] => 20";

        assertEquals(expected, hand.toString());
    }

    @Test
    public void stringWithHidden() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardType.Ace, CardSuit.Clubs));
        hand.addCard(new Card(7, CardSuit.Diamonds));

        hand.getCard(1).hide();

        String expected = "[Туз Трефы (11); <скрытая карта>]";

        assertEquals(expected, hand.toString());
    }

    @Test
    public void value() {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(CardType.Ace, CardSuit.Hearts));
        hand1.addCard(new Card(CardType.Ace, CardSuit.Diamonds));
        hand1.addCard(new Card(5, CardSuit.Clubs));

        assertEquals(7, hand1.getValue());

        Hand hand2 = new Hand();
        hand2.addCard(new Card(CardType.Ace, CardSuit.Clubs));
        hand2.addCard(new Card(CardType.Jack, CardSuit.Spades));
        hand2.addCard(new Card(9, CardSuit.Diamonds));

        assertEquals(20, hand2.getValue());

        Hand hand3 = new Hand();
        hand3.addCard(new Card(CardType.Queen, CardSuit.Diamonds));
        hand3.addCard(new Card(8, CardSuit.Spades));
        hand3.addCard(new Card(5, CardSuit.Hearts));

        assertEquals(23, hand3.getValue());
    }

    @Test
    public void valueWithHidden() {
        Hand hand = new Hand();
        CardPool pool = new CardPool();

        hand.addCard(pool.takeCard(false));
        hand.addCard(pool.takeCard(true));

        assertEquals(0, hand.getValue());
    }
}
