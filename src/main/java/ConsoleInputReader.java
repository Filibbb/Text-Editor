import java.util.Scanner;

public class ConsoleInputReader {

    private final Scanner inputReader;
    private static final String notAllowedTextElements = "[^a-zA-Z0-9.,:;!?’()\"%@+*\\-\\[\\]{}/&#$]";

    public ConsoleInputReader() {
        inputReader = new Scanner(System.in);
    }

    public String stringInputReader() {
        String userTextInput = inputReader.nextLine();

        if (userTextInput.matches(notAllowedTextElements)) {
            System.err.println("Your text doesn't just contain letters, numbers, spaces or punctuation marks such as .,:;-!?’()\"%@+*[]{}/&#$");
            return stringInputReader();
        }

        return userTextInput.trim();
    }


    //Methode für Int input mit den zu ignorierenden Zahlen.


    //Im Whileloop methode aufrufen.
    public void closeScanner() {
        inputReader.close();
    }

}
