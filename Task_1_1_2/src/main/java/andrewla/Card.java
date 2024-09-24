package andrewla;

import java.util.HashMap;
import java.util.Objects;

/**
 * Class which store all info about cards. <br> This class can present all 54 cards.
 */
public class Card {

    /**
     * Create number card.
     *
     * @param rank rank of card (from 2 to 10)
     * @param suit suit of card
     */
    public Card(int rank, CardSuit suit) {
        this.suit = suit;
        this.type = CardType.Number;

        this.rank = rank;
    }

    /**
     * Create symbol card.
     *
     * @param type type of card (Jack, Queen, King, Ace)
     * @param suit suit of card
     */
    public Card(CardType type, CardSuit suit) {
        this.suit = suit;
        this.type = type;

        this.rank = null;
    }

    /**
     * Returns rank of cars.
     *
     * @return rank
     */
    public int getRank() {
        if (rank == null) {
            return 0;
        }

        return rank;
    }

    /**
     * Hides a card (needed for displaying).
     */
    public void hide() {
        isHidden = true;
    }

    /**
     * Shows a card (needed for displaying).
     */
    public void show() {
        isHidden = false;
    }

    /**
     * Returns boolean which indicates hided card or no.
     *
     * @return boolean indicator
     */
    public boolean isHidden() {
        return isHidden;
    }

    /**
     * Returns a type of card
     *
     * @return type of card
     */
    public CardType getType() {
        return type;
    }

    @Override
    public String toString() {
        if (this.isHidden) {
            return "<скрытая карта>";
        }

        String name = (rank == null) ? typeNames.get(type) : numberNames.get(rank);

        name += ' ';
        name += suitNames.get(suit);

        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return isHidden == card.isHidden && suit == card.suit && type == card.type
            && Objects.equals(rank, card.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, type, rank, isHidden);
    }

    private final CardSuit suit;
    private final CardType type;
    private final Integer rank;

    private boolean isHidden = false;

    private static final HashMap<Integer, String> numberNames = createNumberMap();
    private static final HashMap<CardType, String> typeNames = createTypeMap();
    private static final HashMap<CardSuit, String> suitNames = createSuitMap();

    /**
     * Helping function which creates map of number of cards
     * @return map of cards number
     */
    private static HashMap<Integer, String> createNumberMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "Двойка");
        map.put(3, "Тройка");
        map.put(4, "Четверка");
        map.put(5, "Пятерка");
        map.put(6, "Шестерка");
        map.put(7, "Семерка");
        map.put(8, "Восьмерка");
        map.put(9, "Девятка");
        map.put(10, "Десятка");

        return map;
    }

    /**
     * Helping function which creates map of type of cards
     * @return map of cards type
     */
    private static HashMap<CardType, String> createTypeMap() {
        HashMap<CardType, String> map = new HashMap<>();
        map.put(CardType.Jack, "Валет");
        map.put(CardType.Queen, "Дама");
        map.put(CardType.King, "Король");
        map.put(CardType.Ace, "Туз");

        return map;
    }

    /**
     * Helping function which creates map of suit of cards
     * @return map of cards suit
     */
    private static HashMap<CardSuit, String> createSuitMap() {
        HashMap<CardSuit, String> map = new HashMap<>();
        map.put(CardSuit.Hearts, "Червы");
        map.put(CardSuit.Diamonds, "Бубы");
        map.put(CardSuit.Clubs, "Трефы");
        map.put(CardSuit.Spades, "Пики");

        return map;
    }
}
