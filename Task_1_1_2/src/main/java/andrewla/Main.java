package andrewla;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Блэкджек!");

        // Game loop
        boolean isRunning = true;

        int dealersScore = 0;
        int playersScore = 0;

        while (isRunning) {
            Round round = new Round();
            RoundResult result = round.play();

            switch (result) {
                case DealerWins: {
                    dealersScore++;
                }
                break;

                case PlayerWins: {
                    playersScore++;
                }
                break;

                case Tie:
                    break;
            }

            System.out.println();

            System.out.printf("Счет после %d-го раунда:%n", Round.index);
            System.out.printf("Вы: %d%n", playersScore);
            System.out.printf("Дилер: %d%n", dealersScore);

            System.out.println();

            isRunning = InputHandler.askUser("Хотите еще раунд?");
        }

        System.out.println("До свидания!");
    }
}
