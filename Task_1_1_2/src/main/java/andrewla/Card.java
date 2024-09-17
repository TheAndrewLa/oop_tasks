package andrewla;

import java.util.HashMap;

public class Card {

    public Card(int rank, CardSuit suit) {
        this.suit = suit;
        this.type = CardType.Number;

        this.rank = rank;
    }

    public Card(CardType type, CardSuit suit) {
        this.suit = suit;
        this.type = type;

        this.rank = null;
    }

    public int getRank() {
        if (rank == null) {
            return 0;
        }

        return rank;
    }

    public CardType getType() {
        return type;
    }

    @Override
    public String toString() {
        String name;

        String[] number_names = new String[]{
            "Двойка",
            "Тройка",
            "Четверка",
            "Пятерка",
            "Шестерка",
            "Семерка",
            "Восьмерка",
            "Девятка",
            "Десятка",
        };

        HashMap<CardType, String> type_names = new HashMap<>();
        type_names.put(CardType.Jack, "Валет");
        type_names.put(CardType.Queen, "Дама");
        type_names.put(CardType.King, "Король");
        type_names.put(CardType.Ace, "Туз");

        if (type != CardType.Number) {
            assert (rank == null);
            name = type_names.get(type);
        }
        else {
            assert (rank != null) && (rank >= 2 && rank <= 10);
            name = number_names[rank - 2];
        }

        HashMap<CardSuit, String> suit_names = new HashMap<>();
        suit_names.put(CardSuit.Hearts, "Червы");
        suit_names.put(CardSuit.Diamonds, "Бубы");
        suit_names.put(CardSuit.Clubs, "Трефы");
        suit_names.put(CardSuit.Spades, "Пики");

        return name.concat(suit_names.get(suit));
    }

    private final CardSuit suit;
    private final CardType type;
    private final Integer rank;
}
