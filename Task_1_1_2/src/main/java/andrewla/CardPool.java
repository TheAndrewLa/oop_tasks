package andrewla;

import java.util.ArrayList;
import java.util.Collections;

public class CardPool {
    public CardPool() {
        cards = new ArrayList<>();

        for (int i = 2; i <= 10; i++) {
            AddNumberCards(i);
        }

        AddSymbolCards(CardType.Jack);
        AddSymbolCards(CardType.Queen);
        AddSymbolCards(CardType.King);
        AddSymbolCards(CardType.Ace);

        Collections.shuffle(cards);
    }

    public Card popCard() {
        return cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return !cards.isEmpty();
    }

    private void AddNumberCards(int rank) {
        cards.add(new Card(rank, CardSuit.Hearts));
        cards.add(new Card(rank, CardSuit.Diamonds));
        cards.add(new Card(rank, CardSuit.Clubs));
        cards.add(new Card(rank, CardSuit.Spades));
    }

    private void AddSymbolCards(CardType type) {
        cards.add(new Card(type, CardSuit.Hearts));
        cards.add(new Card(type, CardSuit.Diamonds));
        cards.add(new Card(type, CardSuit.Clubs));
        cards.add(new Card(type, CardSuit.Spades));
    }

    private final ArrayList<Card> cards;
}
