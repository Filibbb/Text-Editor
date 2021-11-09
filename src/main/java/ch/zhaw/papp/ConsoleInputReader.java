package ch.zhaw.papp;

import java.util.Scanner;

/**
 * Reads the user input and checks whether it is a valid entry.
 *
 * @author fupat002
 * @version 1.0.0
 */
public class ConsoleInputReader {
    private final Scanner inputReader = new Scanner(System.in);

    /**
     * Read the next line if one exists otherwise "waits" till one is entered.
     *
     * @return the next inputted line if possible
     * @author abuechi
     */
    public String readNextLine() {
        if (inputReader.hasNext()) {
            String userTextInput = inputReader.nextLine();
            return userTextInput.trim();
        } else {
            return readNextLine();
        }
    }
}
