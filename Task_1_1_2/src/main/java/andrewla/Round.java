package andrewla;

/**
 * Class which provide function for round stage for game loop.
 */
public class Round {

    /**
     * Default constructor of round class.
     *
     * @param inputHandler a game input class
     */
    public Round(GameInput inputHandler) {
        Index++;

        System.out.printf("Раунд %d%n", Index);

        dealersHand = new Hand();
        playersHand = new Hand();
        pool = new CardPool();

        handler = new GameInput();
    }

    /**
     * Constructor of Round class with predefined card pool.
     * Should be used for testing.
     *
     * @param inputHandler   a game input class
     * @param predefinedPool a predefined card pool class
     */
    protected Round(GameInput inputHandler, CardPool predefinedPool) {
        Index++;

        System.out.printf("Раунд %d%n", Index);

        dealersHand = new Hand();
        playersHand = new Hand();

        pool = predefinedPool;

        handler = inputHandler;
    }

    /**
     * Functions starts game loop of round.
     *
     * @return result of round
     */
    public RoundResult play() {
        prepareRound();

        System.out.println("Дилер раздал карты");
        printHands();

        System.out.println();

        // Dealer hand can not be calculated at this time (because one card is hidden)

        if (playersHand.getValue() == PointsTarget) {
            System.out.println("Вы выиграли раунд!\n");
            return RoundResult.PlayerWins;
        }

        playersTurn();

        if (playersHand.getValue() > PointsTarget) {
            System.out.println("Дилер выиграл раунд!\n");
            return RoundResult.DealerWins;
        } else if (playersHand.getValue() == 21) {
            System.out.println("Вы выиграли раунд!\n");
            return RoundResult.PlayerWins;
        }

        dealersTurn();

        if (dealersHand.getValue() > PointsTarget) {
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
     * Functions prepares round: gives two cards for player and dealer.
     */
    protected void prepareRound() {
        playersHand.addCard(pool.takeCardOpen());
        playersHand.addCard(pool.takeCardOpen());

        dealersHand.addCard(pool.takeCardOpen());
        dealersHand.addCard(pool.takeCardHide());
    }

    /**
     * Helping function which emulates players turn.
     * Used in game loop.
     */
    protected void playersTurn() {
        System.out.println("Ваш ход");
        System.out.println("-----------------");

        while (playersHand.getValue() < PointsTarget && !pool.isEmpty() && handler.askUser(
            "Хотите карту?")) {
            Card card = pool.takeCard(false);

            System.out.printf("Вы открыли карту «%s»%n", card.toString());
            playersHand.addCard(card);

            printHands();
            System.out.println();
        }
    }

    /**
     * Helping function which emulates dealers loop.
     * Used in game loop.
     */
    protected void dealersTurn() {
        System.out.println("Ход дилера");
        System.out.println("---------------");

        Card dealerCard = dealersHand.getCard(dealersHand.getCardsCount() - 1);
        dealerCard.show();

        dealersHand.calculateValue();

        System.out.printf("Диллер открывает закрытую карту «%s»%n", dealerCard);
        printHands();

        while (dealersHand.getValue() < DealerPointsLimit && !pool.isEmpty()) {
            Card card = pool.takeCard(false);
            dealersHand.addCard(card);

            System.out.printf("Дилер открывает карту «%s»%n", card);
            printHands();
            System.out.println('\n');
        }
    }

    /**
     * Helping function which prints current decks state (players & dealers).
     */
    private void printHands() {
        System.out.printf("\tВаши карты: %s%n", playersHand);
        System.out.printf("\tКарты дилера: %s%n", dealersHand);
    }

    private final Hand dealersHand;
    private final Hand playersHand;

    private final CardPool pool;
    private final GameInput handler;

    private static final int PointsTarget = 21;
    private static final int DealerPointsLimit = 17;

    public static int Index = 0;

}
