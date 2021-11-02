import java.util.HashSet;
import java.util.Set;

public class Commands {
    private final Set<String> availableCommands = new HashSet<>();

    public Commands() {
        availableCommands.add("DUMMY");
        availableCommands.add("DEL");
        availableCommands.add("ADD");
        availableCommands.add("EXIT");
        availableCommands.add("FORMAT RAW");
        availableCommands.add("FORMAT FIX");
        availableCommands.add("INDEX");
        availableCommands.add("PRINT");
        availableCommands.add("REPLACE");
        availableCommands.add("SHOWCOMMANDS");
    }

    public void showCommands() {
        System.out.println("Available Commands:");
        System.out.println("ADD : Add Text");
        System.out.println("DEL (n) : Delete Paragraph n");
        System.out.println("PRINT : ");
        System.out.println("DUMMY : ");
        System.out.println("FORMAT RAW : ");
        System.out.println("FORMAT FIX : ");
        System.out.println("INDEX : ");
        System.out.println("REPLACE : ");
        System.out.println("EXIT : Exit TextEditor!");
    }
}
