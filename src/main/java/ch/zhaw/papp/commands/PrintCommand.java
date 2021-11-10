package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

/**
 * Command class for the print command
 *
 * @author fupat002
 * @version 1.0.0
 */
public class PrintCommand {

    private PrintCommand() {
    }

    /**
     * Prints all text in the currently set format.
     *
     * @param textData  the current TextData object
     * @param formatter the formatter object with the current format
     * @author fupat002
     */
    public static void print(TextData textData, Formatter formatter) {
        if (!textData.getParagraphs().isEmpty()) {
            if (formatter.getUserParagraphWishLength() == null) {
                printRaw(textData);
            } else {
                formatter.executeFormatFixCommand(textData);
                for (int i = 0; i < formatter.getFormattedParagraphs().size(); i++) {
                    System.out.println((i + 1) + ": " + formatter.getFormattedParagraphs().get(i));
                }
                System.out.println();
                System.out.println("------------------------");
            }
        } else {
            System.err.println("There is no text. Add some with the commands below.");
        }
    }

    /**
     * Prints the text in raw format
     *
     * @param textData the current TextData object
     * @author fupat002
     */
    public static void printRaw(TextData textData) {
        if (!textData.getParagraphs().isEmpty()) {
            for (int i = 0; i < textData.getParagraphs().size(); i++) {
                System.out.println((i + 1) + ": " + textData.getParagraphs().get(i));
            }
            System.out.println();
            System.out.println("------------------------");
        } else {
            System.err.println("There is no text. Add some with the commands below.");
        }
    }
}
