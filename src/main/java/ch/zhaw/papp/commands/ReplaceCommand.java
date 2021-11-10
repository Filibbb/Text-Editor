package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

/**
 * Utility class for the replace command
 *
 * @author fupat002
 * @version 1.0.0
 */
public class ReplaceCommand {

    private ReplaceCommand() {
    }

    /**
     * Executes the replacement commands in the last or selected paragraph.
     *
     * @param text          the current TextData object
     * @param textToReplace the text / word that needs to be replaced
     * @param command       the entered command
     * @param newText       the text / word to replace it with
     * @author fupat002
     */
    public static void replaceCommand(TextData text, String textToReplace, String newText, Command command) {
        if (!text.getParagraphs().isEmpty()) {
            if (command.hasParams()) {
                if (text.isValidParagraph(command.getNumericParams())) {
                    int paragraph = command.getNumericParams();
                    text.replaceText(textToReplace, paragraph, newText);
                } else {
                    System.err.println("The text is not that long. Text size: " + text.getParagraphs().size());
                }
            } else {
                text.replaceText(textToReplace, null, newText);
            }
        }
    }
}
