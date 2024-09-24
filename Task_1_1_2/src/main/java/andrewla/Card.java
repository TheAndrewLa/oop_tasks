package andrewla;

import java.util.HashMap;
import java.util.Objects;

/**
 * Class which store all info about cards
 * This class can present all 54 cards
 */
public class Card {

    /**
     * Create number card
     * @param rank rank of card (from 2 to 10)
     * @param suit suit of card
     */
    public Card(int rank, CardSuit suit) {
        this.suit = suit;
        this.type = CardType.Number;

        this.rank = rank;
    }

    /**
     * Create symbol card
     * @param type type of card (Jack, Queen, King, Ace)
     * @param suit suit of card
     */
    public Card(CardType type, CardSuit suit) {
        this.suit = suit;
        this.type = type;

        this.rank = null;
    }

    /**
     * @return rank of card
     */
    public int getRank() {
        if (rank == null) {
            return 0;
        }

        return rank;
    }

    /**
     * Hides a card (needed for displaying)
     */
    public void hide() {
        isHidden = true;
    }

    /**
     * Shows a card (needed for displaying)
     */
    public void show() {
        isHidden = false;
    }

    /**
     * @return boolean value indicates hided card or no
     */
    public boolean isHidden() {
        return isHidden;
    }

    /**
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

        String name = (rank == null)
            ? typeNames.get(type)
            : numberNames.get(rank);

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

    private static final HashMap<Integer, String> numberNames = new HashMap<>(){{
        put(2, "Двойка");
        put(3, "Тройка");
        put(4, "Четверка");
        put(5, "Пятерка");
        put(6, "Шестерка");
        put(7, "Семерка");
        put(8, "Восьмерка");
        put(9, "Девятка");
        put(10, "Десятка");
    }};

    private static final HashMap<CardType, String> typeNames = new HashMap<>(){{
        put(CardType.Jack, "Валет");
        put(CardType.Queen, "Дама");
        put(CardType.King, "Король");
        put(CardType.Ace, "Туз");
    }};

    private static final HashMap<CardSuit, String> suitNames = new HashMap<>(){{
        put(CardSuit.Hearts, "Червы");
        put(CardSuit.Diamonds, "Бубы");
        put(CardSuit.Clubs, "Трефы");
        put(CardSuit.Spades, "Пики");
    }};
}
