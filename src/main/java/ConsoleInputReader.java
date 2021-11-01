import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleInputReader {

    private final Scanner inputReader;
    private Set<String> allowedTextElements = new HashSet<>();

    //Ein HashSet machen, dass nur erlaubte zeichen enthält.

    public ConsoleInputReader() {
        inputReader = new Scanner(System.in);
        addAllowedTextelements();
    }

    private void addAllowedTextelements() {
        allowedTextElements.add("[a-zA-Z]");//Letters
        allowedTextElements.add("[0-9]");//digits
        allowedTextElements.add(".");
        allowedTextElements.add(",");
        allowedTextElements.add(":");
        allowedTextElements.add(";");
        allowedTextElements.add("-");
        allowedTextElements.add("!");
        allowedTextElements.add("?");
        allowedTextElements.add("’");
        allowedTextElements.add("(");
        allowedTextElements.add(")");
        allowedTextElements.add("\"");
        allowedTextElements.add("%");
        allowedTextElements.add("@");
        allowedTextElements.add("+");
        allowedTextElements.add("*");
        allowedTextElements.add("[");
        allowedTextElements.add("]");
        allowedTextElements.add("{");
        allowedTextElements.add("}");
        allowedTextElements.add("/");
        allowedTextElements.add("&");
        allowedTextElements.add("#");
        allowedTextElements.add("$");
    }





    //Methode für Int input mit den zu ignorierenden Zahlen.


    //Im Whileloop methode aufrufen.
    public void closeScanner() {
        inputReader.close();
    }

}
