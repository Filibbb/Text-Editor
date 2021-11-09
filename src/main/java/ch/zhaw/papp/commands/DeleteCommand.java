package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

/**
 * Command Class to handle deletion of paragraphs
 *
 * @author weberph5
 * @version 1.0.0
 */
public class DeleteCommand {

    private DeleteCommand() {
    }

    /**
     * Deletes text in the given paragraph
     *
     * @param textData        the current text object
     * @param paragraphNumber the paragraph to be deleted
     * @author weberph5
     */
    public static void deleteCommand(TextData textData, int paragraphNumber) {
        final boolean successFul = textData.deleteTextAt(paragraphNumber);
        if (successFul) {
            System.out.println("Deleted Paragraph " + paragraphNumber);
        } else {
            System.err.println("Deletion not successful. Paragraph is invalid");
        }
    }

    /**
     * Deletes text in the last paragraph
     *
     * @param textData the current text object
     * @author weberph5
     */
    public static void deleteCommand(TextData textData) {
        final boolean successFul = textData.deleteTextAt(null);
        if (successFul) {
            System.out.println("Deleted last Paragraph");
        } else {
            System.err.println("No text available to delete! Deletion obviously not successful!");
        }
    }
}
