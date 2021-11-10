package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

/**
 * Command Class to handle deletion of paragraphs
 *
 * @author weberph5
 * @version 1.0.0
 */
public class DeleteCommand {
    private final Command command;

    /**
     * Creates an instance of the delete command with its related command information.
     *
     * @param command the information on how the command should be executed
     * @author abuechi
     */
    public DeleteCommand(Command command) {
        this.command = command;
    }

    /**
     * Deletes text in the given paragraph or at the last position
     *
     * @param textData the text to execute the command on
     * @author abuechi
     */
    public void execute(TextData textData) {
        if (command != null) {
            deleteCommand(textData, command.getNumericParams());
        } else {
            System.err.println("Command is missing the command information.");
        }
    }

    /**
     * Deletes text in the given paragraph
     *
     * @param textData        the current text object
     * @param paragraphNumber the paragraph to be deleted
     * @author weberph5
     */
    private void deleteCommand(TextData textData, Integer paragraphNumber) {
        final boolean successFul = textData.deleteTextAt(paragraphNumber);
        if (successFul) {
            String paragraphStatement = paragraphNumber == null ? "at last position" : paragraphNumber.toString();
            System.out.println("Deleted Paragraph " + paragraphStatement);
        } else {
            System.err.println("Deletion not successful. Paragraph is invalid");
        }
    }
}
