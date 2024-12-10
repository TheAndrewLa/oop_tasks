package andrewla;

import java.util.Scanner;

/**
 * Class which provides input functions.
 */
public class GameInput {

    /**
     * Initializes standard user input.
     */
    public GameInput() {
        usersInput = true;
        scanner = new Scanner(System.in);
    }

    /**
     * Initialized input with predefined answers. Should be used for testing.
     *
     * @param emulation an input
     */
    protected GameInput(String emulation) {
        usersInput = false;
        scanner = new Scanner(emulation);
    }

    /**
     * Function which prints your message and takes input. Contract: 'Y' or Enter is positive
     * answer, anything else (including EOF) is negative.
     *
     * @param message message to print
     * @return user's answer (positive or negative)
     */
    public boolean askUser(String message) {
        if (usersInput) {
            System.out.print(message);
            System.out.print(' ');
            System.out.print("[Y/n]: ");
        }

        if (!scanner.hasNextLine()) {

            if (usersInput) {
                System.out.println();
            }

            return false;
        }

        String line = scanner.nextLine();

        return line.isEmpty() || line.equals("Y");
    }

    private final Scanner scanner;
    private final boolean usersInput;
}
