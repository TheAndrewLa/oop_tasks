package andrewla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {

    @Test
    public void ToString() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardType.Queen, CardSuit.Spades));
        hand.addCard(new Card(3, CardSuit.Hearts));
        hand.addCard(new Card(7, CardSuit.Spades));

        String expected = "[Дама Пики (10); Тройка Червы (3); Семерка Пики (7)] => 20";

        assertEquals(expected, hand.toString());
    }

    @Test
    public void ToStringWithHidden() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardType.Ace, CardSuit.Clubs));
        hand.addCard(new Card(7, CardSuit.Diamonds));

        hand.getCard(1).hide();

        String expected = "[Туз Трефы (11); <скрытая карта>]";

        assertEquals(expected, hand.toString());
    }

    @Test
    public void Value() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardType.Ace, CardSuit.Hearts));
        hand.addCard(new Card(CardType.Ace, CardSuit.Diamonds));
        hand.addCard(new Card(5, CardSuit.Clubs));

        assertEquals(7, hand.getValue());
    }

    @Test
    public void ValueWithHidden() {
        Hand hand = new Hand();
        CardPool pool = new CardPool();

        hand.addCard(pool.takeCard(false));
        hand.addCard(pool.takeCard(true));

        assertEquals(0, hand.getValue());
    }
}
