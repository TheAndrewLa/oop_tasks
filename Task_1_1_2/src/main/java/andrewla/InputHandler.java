package andrewla;

import java.util.Scanner;

/**
 * Class which provides IO stuff via static functions.
 */
public class InputHandler {

    /**
     * Function which prints your message and takes user's input.
     *
     * @param message message to print
     * @return user's answer (positive or negative)
     */
    public static boolean askUser(String message) {
        System.out.print(message);
        System.out.print(' ');
        System.out.print("[Y/n]: ");

        String result = scanner.nextLine();

        return !result.equals("n");
    }

    private static final Scanner scanner = new Scanner(System.in);
}
