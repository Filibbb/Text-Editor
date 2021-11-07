package ch.zhaw.papp.commands;

import ch.zhaw.papp.CommandHandler;
import ch.zhaw.papp.TextData;

/**
 * contains the method to print the text.
 * @author fupat002
 */
public class PrintCommand {
    private static final CommandHandler commandHandler = new CommandHandler();

    private PrintCommand(){
    }

    /**
     * Prints the whole text.
     *
     * @param textData the class that contains the text for the replacement
     * @author fupat002
     */
    public static void print(TextData textData) {
        if (!textData.getParagraphs().isEmpty()) {
            for (int i = 0; i < textData.getParagraphs().size(); i++) {
                System.out.println((i+1) + ": " + textData.getParagraphs().get(i));
            }
            System.out.println();
            System.out.println("------------------------");
        } else {
            System.err.println("There is no text. Add some with the commands below.");
            commandHandler.showCommands();
        }
    }
}
