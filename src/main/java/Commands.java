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
    }
}
