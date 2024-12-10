package andrewla;

import java.util.ArrayList;

/**
 * Class which presents hand. <br> Provide functions to print hand and calculate value of hand.
 */
public class Hand {

    /**
     * Default constructor for class 'Hand'.
     */
    Hand() {
        cards = new ArrayList<>();
    }

    @Override
    public String toString() {
        if (cards.isEmpty()) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append('[');

        stringBuilder.append(cardToString(cards.get(0)));

        for (int i = 1; i < cards.size(); i++) {
            stringBuilder.append("; ");
            stringBuilder.append(cardToString(cards.get(i)));
        }

        stringBuilder.append(']');

        if (canCalculate()) {
            calculateValue();
            stringBuilder.append(" => ");
            stringBuilder.append(value);
        }

        return stringBuilder.toString();
    }

    /**
     * Add card to the end of hand.
     *
     * @param card card to be added
     */
    public void addCard(Card card) {
        cards.add(card);
        calculateValue();
    }

    /**
     * Calculates total value of cards in hand.
     */
    public void calculateValue() {
        if (!canCalculate()) {
            value = null;
            valueOfAce = 11;
            return;
        }

        int aces = 0;
        value = 0;

        for (Card i : cards) {
            switch (i.getType()) {
                case Number:
                    value += i.getRank();
                    break;

                case Jack:
                case Queen:
                case King:
                    value += 10;
                    break;

                case Ace:
                    aces += 1;
                    break;

                default:
                    throw new RuntimeException("Unknown enum value!");
            }
        }

        if (11 * aces + value > 21) {
            value += aces;
            valueOfAce = 1;
        } else {
            value += 11 * aces;
            valueOfAce = 11;
        }
    }

    /**
     * @param index index of card
     * @return card in hand with given index
     */
    public Card getCard(int index) {
        return cards.get(index);
    }

    /**
     * Returns count of cards in hand.
     *
     * @return count of cards
     */
    public int getCardsCount() {
        return cards.size();
    }

    /**
     * Returns value of cards in hand.
     *
     * @return value of cards
     */
    public int getValue() {
        if (value == null) {
            return 0;
        }

        return value;
    }

    /**
     * Brings String presentation of card depending on whole hand.
     *
     * @param card - card to be converted to string
     * @return card to be converted in string
     */
    private String cardToString(Card card) {
        StringBuilder sb = new StringBuilder();
        sb.append(card.toString());

        if (!card.isHidden()) {
            sb.append(' ');
            sb.append('(');

            switch (card.getType()) {
                case Number:
                    sb.append(card.getRank());
                    break;

                case Jack:
                case Queen:
                case King:
                    sb.append("10");
                    break;

                case Ace:
                    sb.append(valueOfAce);
                    break;

                default:
                    throw new RuntimeException("Unknown enum value!");
            }

            sb.append(')');
        }

        return sb.toString();
    }

    /**
     * Determine if value of cards in hand be calculated.
     * if there are hidden cards - no (false), otherwise - yes (true).
     *
     * @return possibility of calculation value of hand
     */
    private boolean canCalculate() {
        if (cards.isEmpty()) {
            return false;
        }

        for (Card i : this.cards) {
            if (i.isHidden()) {
                return false;
            }
        }

        return true;
    }

    private final ArrayList<Card> cards;
    private int valueOfAce = 11;
    private Integer value = null;
}
