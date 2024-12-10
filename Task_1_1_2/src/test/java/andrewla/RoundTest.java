package andrewla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class which provides testing of Round logic.
 * There are different scenarios of rounds.
 */
public class RoundTest {

    @Test
    public void scenario1() {

        // Scenario 1
        // Win at start of the game
        // 21

        Card[] cards = new Card[4];

        cards[0] = new Card(10, CardSuit.Clubs);
        cards[1] = new Card(CardType.Jack, CardSuit.Clubs);

        cards[2] = new Card(10, CardSuit.Spades);
        cards[3] = new Card(CardType.Ace, CardSuit.Spades);

        GameInput input = new GameInput("");

        Round round = new Round(input, new CardPool(cards));

        assertEquals(round.play(), RoundResult.PlayerWins);
    }

    @Test
    public void scenario2() {

        // Scenario 2
        // Players denys & dealer takes card to win
        // 16 : 19

        Card[] cards = new Card[6];

        cards[0] = new Card(CardType.Queen, CardSuit.Diamonds);
        cards[1] = new Card(3, CardSuit.Clubs);

        cards[2] = new Card(2, CardSuit.Spades);
        cards[3] = new Card(4, CardSuit.Clubs);

        cards[4] = new Card(CardType.Jack, CardSuit.Hearts);
        cards[5] = new Card(6, CardSuit.Diamonds);

        GameInput input = new GameInput("n");

        Round round = new Round(input, new CardPool(cards));

        assertEquals(round.play(), RoundResult.DealerWins);
    }

    @Test
    public void scenario3() {

        // Scenario 3
        // Players denys & dealer takes card to lose
        // 16 : 25

        Card[] cards = new Card[6];

        cards[0] = new Card(CardType.Jack, CardSuit.Diamonds);
        cards[1] = new Card(7, CardSuit.Clubs);

        cards[2] = new Card(3, CardSuit.Spades);
        cards[3] = new Card(5, CardSuit.Diamonds);

        cards[4] = new Card(8, CardSuit.Spades);
        cards[5] = new Card(8, CardSuit.Clubs);

        GameInput input = new GameInput("n");

        Round round = new Round(input, new CardPool(cards));

        assertEquals(round.play(), RoundResult.PlayerWins);
    }

    @Test
    public void scenario4() {

        // Scenario 4
        // Players denys & dealer takes card to tie
        // 20 : 20

        Card[] cards = new Card[7];

        cards[0] = new Card(6, CardSuit.Diamonds);
        cards[1] = new Card(2, CardSuit.Clubs);
        cards[2] = new Card(4, CardSuit.Clubs);

        cards[3] = new Card(3, CardSuit.Spades);
        cards[4] = new Card(5, CardSuit.Diamonds);

        cards[5] = new Card(CardType.Jack, CardSuit.Hearts);
        cards[6] = new Card(CardType.Queen, CardSuit.Hearts);

        GameInput input = new GameInput("n");

        Round round = new Round(input, new CardPool(cards));

        assertEquals(round.play(), RoundResult.Tie);
    }

    @Test
    public void scenario5() {

        // Scenario 5
        // Player takes card to win
        // 20 : 19

        Card[] cards = new Card[7];

        cards[0] = new Card(4, CardSuit.Hearts);
        cards[1] = new Card(2, CardSuit.Clubs);
        cards[2] = new Card(6, CardSuit.Spades);

        cards[3] = new Card(9, CardSuit.Diamonds);
        cards[4] = new Card(CardType.King, CardSuit.Hearts);

        cards[5] = new Card(5, CardSuit.Hearts);
        cards[6] = new Card(7, CardSuit.Clubs);

        GameInput input = new GameInput("Y\nY\nn");

        Round round = new Round(input, new CardPool(cards));

        assertEquals(round.play(), RoundResult.PlayerWins);
    }

    @Test
    public void scenario6() {

        // Scenario 6
        // Player takes card to lose
        // 24 : ?

        Card[] cards = new Card[7];

        cards[0] = new Card(CardType.Jack, CardSuit.Hearts);
        cards[1] = new Card(4, CardSuit.Clubs);
        cards[2] = new Card(2, CardSuit.Spades);

        cards[3] = new Card(CardType.Jack, CardSuit.Spades);
        cards[4] = new Card(CardType.Queen, CardSuit.Hearts);

        cards[5] = new Card(5, CardSuit.Hearts);
        cards[6] = new Card(2, CardSuit.Diamonds);

        GameInput input = new GameInput("Y\nY\nY\nn");

        Round round = new Round(input, new CardPool(cards));

        assertEquals(round.play(), RoundResult.DealerWins);
    }

    @Test
    public void scenario7() {

        // Scenario 7
        // Player & dealer take cards to tie
        // 20 : 20

        Card[] cards = new Card[9];

        cards[0] = new Card(4, CardSuit.Diamonds);
        cards[1] = new Card(3, CardSuit.Spades);
        cards[2] = new Card(3, CardSuit.Clubs);

        cards[3] = new Card(5, CardSuit.Diamonds);
        cards[4] = new Card(CardType.Jack, CardSuit.Spades);

        cards[5] = new Card(8, CardSuit.Clubs);
        cards[6] = new Card(2, CardSuit.Clubs);

        cards[7] = new Card(3, CardSuit.Spades);
        cards[8] = new Card(2, CardSuit.Diamonds);

        GameInput input = new GameInput("Y\nY\nn");

        Round round = new Round(input, new CardPool(cards));

        assertEquals(round.play(), RoundResult.Tie);
    }
}
