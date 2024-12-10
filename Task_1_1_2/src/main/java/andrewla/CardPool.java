package andrewla;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A card pool class Shuffle and store all 54 cards.
 */
public class CardPool {

    /**
     * Default constructor for CardPool. 52 cards will be generated and shuffled.
     */
    public CardPool() {
        cards = new ArrayList<>();

        for (int i = 2; i <= 10; i++) {
            addNumberCards(i);
        }

        addSymbolCards(CardType.Jack);
        addSymbolCards(CardType.Queen);
        addSymbolCards(CardType.King);
        addSymbolCards(CardType.Ace);

        Collections.shuffle(cards);
    }

    /**
     * Constructor of CardPool with predefined cards. Cards will be taken from last to first in
     * array.
     *
     * @param predefined an array of cards used in card pool
     */
    protected CardPool(Card[] predefined) {
        cards = new ArrayList<>();
        Collections.addAll(cards, predefined);
    }

    /**
     * Function takes card.
     *
     * @param isHidden should card be hidden while taking or no
     * @return taken card
     */
    public Card takeCard(boolean isHidden) {
        assert !isEmpty();

        Card card = cards.remove(cards.size() - 1);

        if (isHidden) {
            card.hide();
        }

        return card;
    }

    /**
     * Function takes card. Card will be opened.
     *
     * @return taken card
     */
    public Card takeCardOpen() {
        return takeCard(false);
    }

    /**
     * Function takes card. Card will be hidden.
     *
     * @return taken card
     */
    public Card takeCardHide() {
        return takeCard(true);
    }

    /**
     * Number of cards in pool.
     *
     * @return count of cards
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
     * Add number card (e.g. 3, 7, 9).
     *
     * @param rank rank of card
     */
    private void addNumberCards(int rank) {
        assert rank >= 2 && rank <= 10;

        for (CardSuit suit : CardSuit.values()) {
            cards.add(new Card(rank, suit));
        }
    }

    /**
     * Add symbol card (Queen, Jack, King, Ace).
     *
     * @param type Jack, Queen, King, Ace
     */
    private void addSymbolCards(CardType type) {
        assert type != CardType.Number;

        for (CardSuit suit : CardSuit.values()) {
            cards.add(new Card(type, suit));
        }
    }

    private final ArrayList<Card> cards;
}
