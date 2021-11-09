package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

/**
 * Command class to add new text to the TextData in last or selected paragraph.
 *
 * @author weberph5
 * @version 1.0.0
 */
public class AddTextCommand {

    private AddTextCommand() {
    }

    /**
     * Adds text to the last paragraph.
     *
     * @param textData  the current textData object
     * @param textToAdd new text that is added
     * @author weberph5
     */
    public static void executeAddTextCommand(TextData textData, String textToAdd) {
        addTextCommand(textData, textToAdd, null);
    }

    /**
     * Adds text to the paragraph that was put in with the ADD command
     *
     * @param textData  the current textData object
     * @param textToAdd new text that is added
     * @param offset    paragraph number that was put in with the ADD command
     * @author weberph5
     */
    public static void executeAddTextCommand(TextData textData, String textToAdd, int offset) {
        addTextCommand(textData, textToAdd, offset);
    }

    private static void addTextCommand(TextData text, String textToAdd, Integer offset) {
        final boolean successFull = text.insertTextAt(offset, textToAdd);
        if (!successFull) {
            System.err.println("Adding text was not successful. Paragraph number is invalid");
        }
    }
}
