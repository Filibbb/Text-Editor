import java.util.HashSet;
import java.util.Set;

public class Commands {
    private static final String dummyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sed quam sit amet ex dapibus egestas vel congue metus. Donec id eleifend nisi, vitae eleifend tortor. Quisque euismod vitae nisi fringilla dignissim. In aliquam finibus nisl vel euismod. Ut ac sodales elit. Proin rhoncus libero turpis, eget tempor nisl consequat sed. Proin tempus erat magna, vitae sodales arcu fringilla sit amet. Nunc elementum, velit placerat iaculis feugiat, lectus dolor dapibus velit, in maximus sapien felis at arcu. Nulla mollis suscipit egestas. Phasellus a volutpat libero, nec tincidunt tortor. Aenean mattis ligula eu efficitur ultricies. Vestibulum ac nibh sodales, venenatis sapien vel, maximus nisi. Curabitur feugiat dictum tortor, a hendrerit urna tincidunt vitae.";
    private final Set<String> availableCommands = new HashSet<>();
    ConsoleInputReader inputReader = new ConsoleInputReader();

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

    /**
     * Shows a list and description of all available commands.
     *
     * @author weberph5
     */
    public void showCommands() {
        System.out.println("Available Commands (Case sensitive!):");
        System.out.println("ADD (n) : Add Text to paragraph n. n is optional. Text will be added to the end if n is not set.");
        System.out.println("DEL (n) : Delete Paragraph n");
        System.out.println("FORMAT RAW : Set format to raw with no fix column length with paragraph numbers.");
        System.out.println("FORMAT FIX (b) : Set format to a fix column length b");
        System.out.println("PRINT : Print all text in the currently set format.");
        System.out.println("DUMMY (n) : Add a pre-programmed dummy text to paragraph n. n is optional. Text will be added to the end if n is not set.");
        System.out.println("INDEX : Prints an index of all words starting with an uppercase letter and exist more often than 3 times in all paragraphs.");
        System.out.println("REPLACE (n): Search and replace a string in paragraph n. n is optional. If n is not set search and replace will be done in the last paragraph.");
        System.out.println("SHOWCOMMANDS : Show list of available commands.");
        System.out.println("EXIT : Exit TextEditor!");
        System.out.println("");
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

    /**
     * Executes the replace commands
     *
     * @param text            the class that contains the text
     * @param textToReplace   the text / word that needs to be replaced
     * @param paragraphNumber the paragraph number (optional)
     * @param newText         the text / word to replace it with.
     */
    public void executeReplaceCommand(TextData text, String textToReplace, int paragraphNumber, String newText) {
        if (paragraphNumber == 0) {
            text.replaceInLastParagraph(textToReplace, newText);
        } else {
            text.replaceInVariableParagraph(textToReplace, paragraphNumber, newText);
        }
    }

    /**
     * Prints the whole text.
     *
     * @param textData the class that contains the text for the replacement
     * @author fupat002
     */
    public void print(TextData textData) {
        if (!textData.getParagraphs().isEmpty()) {
            for (String paragraph : textData.getParagraphs()) {
                System.out.println(paragraph);
            }
            System.out.println("--------- This line marks the end. It doesn't belog to the Text! ---------");
        } else {
            System.err.println("There is no text. Add some with the commands below.");
            showCommands();
        }
    }

    /**
     * Closes the TextEditor by setting isRunning in TextEditor to false.
     *
     * @return false
     * @author weberph5
     */
    public boolean exitEditor() {
        System.out.println("Closing the TextEditor. Bye.");
        inputReader.closeScanner();
        return false;
    }
}
