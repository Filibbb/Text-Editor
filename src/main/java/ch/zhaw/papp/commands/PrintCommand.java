package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

/**
 * contains the method to print the text.
 *
 * @author fupat002
 * @version 1.0.0
 */
public class PrintCommand {

    private PrintCommand() {
    }

    /**
     * Prints all text in the selected format.
     * @param textData          the class that contains the text for the replacement
     * @param formatCommand     the class that formats the text.
     * @author fupat002
     */
    public static void print(TextData textData, FormatCommand formatCommand) {
        if (!textData.getParagraphs().isEmpty()) {
            if(formatCommand.getUserParagraphWishLength() == null){
                printRaw(textData);
            }else{
                formatCommand.executeFormatFixCommand(textData);
                for (int i = 0; i < formatCommand.getFormattedParagraphs().size(); i++) {
                    System.out.println((i + 1) + ": " + formatCommand.getFormattedParagraphs().get(i));
                }
                System.out.println();
                System.out.println("------------------------");
            }
        } else {
            System.err.println("There is no text. Add some with the commands below.");
        }
    }

    /**
     * prints aut the text raw for Format Raw or editing
     * @param textData  the class that contains the text for the replacement
     * @author fupat002
     */
    public static void printRaw(TextData textData){
        if (!textData.getParagraphs().isEmpty()) {
            for (int i = 0; i < textData.getParagraphs().size(); i++) {
                System.out.println((i + 1) + ": " + textData.getParagraphs().get(i));
            }
            System.out.println();
            System.out.println("------------------------");
        }else {
            System.err.println("There is no text. Add some with the commands below.");
        }
    }
}
