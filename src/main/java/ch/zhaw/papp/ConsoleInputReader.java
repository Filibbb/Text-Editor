package ch.zhaw.papp;

import java.util.Scanner;

/**
 * Reads the user input and checks whether it is a valid entry.
 *
 * @author fupat002
 * @version 1.0.0
 */
public class ConsoleInputReader {
    private static final Scanner inputReader = new Scanner(System.in);

    private ConsoleInputReader() {
    }

    /**
     * Read the next line if one exists otherwise "waits" till one is entered.
     *
     * @return the next inputted line if possible
     * @author abuechi
     */
    public static String readNextLine() {
        if (inputReader.hasNext()) {
            String userTextInput = inputReader.nextLine();
            return userTextInput.trim();
        } else {
            return readNextLine();
        }
    }

    /**
     * closes the scanner.
     *
     * @author fupat002
     */
    public static void closeScanner() {
        inputReader.close();
    }
}
