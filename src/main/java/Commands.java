import java.util.HashSet;
import java.util.Set;

public class Commands {
    private static final String dummyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sed quam sit amet ex dapibus egestas vel congue metus. Donec id eleifend nisi, vitae eleifend tortor. Quisque euismod vitae nisi fringilla dignissim. In aliquam finibus nisl vel euismod. Ut ac sodales elit. Proin rhoncus libero turpis, eget tempor nisl consequat sed. Proin tempus erat magna, vitae sodales arcu fringilla sit amet. Nunc elementum, velit placerat iaculis feugiat, lectus dolor dapibus velit, in maximus sapien felis at arcu. Nulla mollis suscipit egestas. Phasellus a volutpat libero, nec tincidunt tortor. Aenean mattis ligula eu efficitur ultricies. Vestibulum ac nibh sodales, venenatis sapien vel, maximus nisi. Curabitur feugiat dictum tortor, a hendrerit urna tincidunt vitae.";
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

    public boolean isAvailableCommand(String commandToCheck) {
        return availableCommands.contains(commandToCheck);
    }

    public boolean executeDummyCommand(TextData text) {
        return text.insertTextAt(null, " " + dummyText);
    }

    public boolean executeDummyCommand(TextData text, int offset) {
        return text.insertTextAt(offset, " " + dummyText);
    }
}
