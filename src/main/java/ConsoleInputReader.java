import java.util.Scanner;

/**
 * Reads the user input and checks whether it is a valid entry.
 * This class contains the methods stringInputReader and intInputReader.
 *
 * @author fupat002
 */
public class ConsoleInputReader {

    private final Scanner inputReader;
    private static final String AllowedTextElements = "[a-zA-Z0-9. ,:;!?’()\"%@+*\\-\\[\\]{}/&#$]*";

    /**
     * Creates a new Scanner.
     */
    public ConsoleInputReader() {
        inputReader = new Scanner(System.in);
    }

    /**
     * Reads the user input and checks if there are no other symbols in it than defined in the RegEx code.
     * @return the user input if it contains only symbols that are allowed.
     * @author fupat002
     */
    public String readNextString() {
        String userTextInput = inputReader.nextLine();
        if (!userTextInput.matches(AllowedTextElements)) {
            System.err.println("Your text doesn't just contain letters, numbers, spaces or punctuation marks such as .,:;-!?’()\"%@+*[]{}/&#$");
            return readNextString();
        } else {
            return userTextInput.trim();
        }
    }

    /**
     * Reads the next integer input.
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
     * @author fupat002
     */
    public void closeScanner() {
        inputReader.close();
    }

}
