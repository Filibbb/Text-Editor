package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

/**
 * Command Class to handle deletion of paragraphs
 *
 * @author weberph5
 * @version 1.0.0
 */
public class DeleteCommand {
    /**
     * Deletes text in the given paragraph
     *
     * @param text            the current text object
     * @param paragraphNumber the paragraph to be deleted
     */
    public static void deleteCommand(TextData text, int paragraphNumber) {
        final boolean successFull = text.deleteTextAt(paragraphNumber);
        if (successFull) System.out.println("Deleted Paragraph " + paragraphNumber);
        else System.err.println("Deletion not successful. Paragraph is invalid");
    }

    /**
     * Deletes text in the last paragraph
     *
     * @param text the current text object
     */
    public static void deleteCommand(TextData text) {
        final boolean successFull = text.deleteTextAt(null);
        if (successFull) System.out.println("Deleted last Paragraph");
        else System.err.println("Deletion not successful");
    }
}
