package ch.zhaw.papp;

import java.util.Scanner;

/**
 * Reads the user input and checks whether it is a valid entry.
 *
 * @author fupat002
 */
public class ConsoleInputReader {
    private static final String ALLOWED_TEXT_ELEMENTS = "[a-zA-Z0-9. ,:;!?’()\"%@+*\\-\\[\\]{}/&#$]*";
    private final Scanner inputReader = new Scanner(System.in);

    /**
     * Reads the user input and checks if there are no other symbols in it than defined in the RegEx code.
     *
     * @return the user input if it contains only symbols that are allowed.
     * @author fupat002
     */
    public String readNextTextString() {
        String userTextInput = inputReader.next();
        if (!userTextInput.matches(ALLOWED_TEXT_ELEMENTS)) {
            System.err.println("Your text doesn't just contain letters, numbers, spaces or punctuation marks such as .,:;-!?’()\"%@+*[]{}/&#$");
            return readNextTextString();
        } else {
            return userTextInput.trim();
        }
    }

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

    /**
     * Reads the next integer input.
     *
     * @return the inputted int that is grater than one.
     * @author fupat002
     */
    public int readNextInt() {
        if (inputReader.hasNextInt()) {
            int userNumberInput = inputReader.nextInt();
            if (userNumberInput < 0) {
                System.err.println("Type in a number greater than zero");
                return readNextInt();
            } else {
                return userNumberInput;
            }
        } else {
            System.err.println("Type in a number");
            inputReader.next();
            return readNextInt();
        }
    }

    /**
     * closes the scanner.
     *
     * @author fupat002
     */
    public void closeScanner() {
        inputReader.close();
    }

}
