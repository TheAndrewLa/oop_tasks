package andrewla;

/**
 * Class which provide function for round stage for game loop
 */
public class Round {

    /**
     * Default constructor of round class
     */
    Round() {
        index++;

        System.out.printf("Раунд %d%n", index);

        dealersHand = new Hand();
        playersHand = new Hand();
        pool = new CardPool();
    }

    /**
     * Functions starts game loop of round
     * @return result of round
     */
    public RoundResult play() {
        playersHand.addCard(pool.takeCard(false));
        playersHand.addCard(pool.takeCard(false));

        dealersHand.addCard(pool.takeCard(false));
        dealersHand.addCard(pool.takeCard(true));

        System.out.println("Дилер раздал карты");
        printHands();

        System.out.println();

        // Dealer hand can not be calculated at this time (because one card is hidden)

        if (playersHand.getValue() == 21) {
            System.out.println("Вы выиграли раунд!\n");
            return RoundResult.PlayerWins;
        }

        playersTurn();

        if (playersHand.getValue() > 21) {
            System.out.println("Дилер выиграл раунд!\n");
            return RoundResult.DealerWins;
        } else if (playersHand.getValue() == 21) {
            System.out.println("Вы выиграли раунд!\n");
            return RoundResult.PlayerWins;
        }

        dealersTurn();

        if (dealersHand.getValue() > 21) {
            System.out.println("Вы выиграли раунд!\n");
            return RoundResult.PlayerWins;
        }

        if (playersHand.getValue() > dealersHand.getValue()) {
            System.out.println("Вы выиграли раунд!\n");
            return RoundResult.PlayerWins;
        } else if (playersHand.getValue() < dealersHand.getValue()) {
            System.out.println("Дилер выиграл раунд!\n");
            return RoundResult.DealerWins;
        } else {
            System.out.println("Ничья!\n");
            return RoundResult.Tie;
        }
    }

    /**
     * Helping function which emulates players turn
     * Used in game loop
     */
    private void playersTurn() {
        System.out.println("Ваш ход");
        System.out.println("---------------");

        while (playersHand.getValue() < 21 && !pool.isEmpty()
            && InputHandler.askUser("Хотите карту?")) {
            Card card = pool.takeCard(false);

            System.out.printf("Вы открыли карту «%s»%n", card.toString());
            playersHand.addCard(card);

            printHands();
            System.out.println();
        }
    }

    /**
     * Helping function which emulates dealers loop
     * Used in game loop
     */
    private void dealersTurn() {
        System.out.println("Ход дилера");
        System.out.println("---------------");

        Card dealerCard = dealersHand.getCard(dealersHand.getCardsCount() - 1);
        dealerCard.show();

        dealersHand.calculateValue();

        System.out.printf("Диллер открывает закрытую карту «%s»%n", dealerCard);
        printHands();

        while (dealersHand.getValue() < 17 && !pool.isEmpty()) {
            Card card = pool.takeCard(false);
            dealersHand.addCard(card);

            System.out.printf("Дилер открывает карту «%s»%n", card);
            printHands();
            System.out.println('\n');
        }
    }

    /**
     * Helping function which prints current decks state (players & dealers)
     */
    private void printHands() {
        System.out.printf("\tВаши карты: %s%n", playersHand);
        System.out.printf("\tКарты дилера: %s%n", dealersHand);
    }

    private final Hand dealersHand;
    private final Hand playersHand;

    private final CardPool pool;

    public static int index = 0;
}
