package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

import static ch.zhaw.papp.ConsoleInputReader.readNextLine;

/**
 * Command class for the replace command
 *
 * @author fupat002
 * @version 1.0.0
 */
public class ReplaceCommand {

    /**
     * Executes the replacement commands.
     *
     * @param textData the current TextData object
     * @param command  the entered command
     * @author fupat002
     */
    public void execute(TextData textData, Command command) {
        System.out.println("Write the word / text you want to replace.");
        String textToReplace = readNextLine();
        System.out.println("Write the word / text you want to replace it with.");
        String newText = readNextLine();
        replaceCommand(textData, textToReplace, newText, command);
    }

    private void replaceCommand(TextData text, String textToReplace, String newText, Command command) {
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
