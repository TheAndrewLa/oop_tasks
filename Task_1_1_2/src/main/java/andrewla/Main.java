package andrewla;

/**
 * Main class contains only main method with game loop.
 */
public class Main {

    /**
     * Main method with game loop.
     *
     * @param args has to be empty
     */
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Блэкджек!");

        GameInput input = new GameInput();

        // Game loop
        boolean isRunning = true;

        int dealersScore = 0;
        int playersScore = 0;

        while (isRunning) {
            Round round = new Round(input);
            RoundResult result = round.play();

            switch (result) {
                case DealerWins:
                    dealersScore++;
                    break;

                case PlayerWins:
                    playersScore++;
                    break;

                case Tie:
                    break;

                default:
                    throw new RuntimeException("Unknown enum value");
            }

            System.out.println();

            System.out.printf("Счет после %d-го раунда:%n", Round.Index);
            System.out.printf("Вы: %d%n", playersScore);
            System.out.printf("Дилер: %d%n", dealersScore);

            System.out.println();

            isRunning = input.askUser("Хотите еще раунд?");
        }

        System.out.println("До свидания!");
    }
}
