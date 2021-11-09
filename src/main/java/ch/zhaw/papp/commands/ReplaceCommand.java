package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

/**
 * replaces a word depending on the user's request, in the last line or in the desired line.
 *
 * @author fupat002
 * @version 1.0.0
 */
public class ReplaceCommand {

    private ReplaceCommand() {
    }

    /**
     * Executes the replacement commands.
     * Depending on the user's preference, in the last line or in the desired line.
     *
     * @param text          the class that contains the text
     * @param textToReplace the text / word that needs to be replaced
     * @param command       the entered command
     * @param newText       the text / word to replace it with
     * @author abuechi
     */
    public static void replaceCommand(TextData text, String textToReplace, String newText, Command command) {
        if (!text.getParagraphs().isEmpty()) {
            if (command.hasParams()) {
                int paragraph = command.getNumericParams();
                text.replaceText(textToReplace, paragraph, newText);
            } else {
                text.replaceText(textToReplace, null, newText);
            }
        } else {
            System.err.println("There is no text. Add some with the commands below.");
        }
    }
}
