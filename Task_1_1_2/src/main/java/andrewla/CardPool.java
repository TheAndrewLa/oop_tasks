package andrewla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * A card pool class Shuffle and store all 54 cards
 */
public class CardPool {

    /**
     * Default constructor for CardPool
     */
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

    /**
     * Function takes card
     *
     * @param isHidden should card be hidden while taking or no
     * @return taken card
     */
    public Card takeCard(boolean isHidden) {
        Card card = cards.remove(cards.size() - 1);

        if (isHidden) {
            card.hide();
        }

        return card;
    }

    /**
     * USED FOR TESTING
     * @return size of card pool
     */
    public int size() {
        return cards.size();
    }

    /**
     * @return boolean that indicates pool is empty or not
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Add number card (2..10)
     *
     * @param rank rank of card
     */
    private void AddNumberCards(int rank) {
        assert rank >= 2 && rank <= 10;

        for (CardSuit suit : CardSuit.values()) {
            cards.add(new Card(rank, suit));
        }
    }

    /**
     * Add symbol card (Queen, Jack, King, Ace)
     *
     * @param type Jack, Queen, King, Ace
     */
    private void AddSymbolCards(CardType type) {
        assert type != CardType.Number;

        for (CardSuit suit : CardSuit.values()) {
            cards.add(new Card(type, suit));
        }
    }

    private final ArrayList<Card> cards;
}
