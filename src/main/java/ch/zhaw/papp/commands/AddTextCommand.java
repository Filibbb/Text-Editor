package ch.zhaw.papp.commands;

import ch.zhaw.papp.ConsoleInputReader;
import ch.zhaw.papp.TextData;

/**
 * Command class to add new text to the TextData in last or selected paragraph.
 *
 * @author weberph5
 * @version 1.0.0
 */
public class AddTextCommand {
    private final Command command;
    private final ConsoleInputReader inputReader = new ConsoleInputReader();

    /**
     * Creates an instance of the delete command with its related command information.
     *
     * @param command the information on how the command should be executed
     * @author abuechi
     */
    public AddTextCommand(Command command) {
        this.command = command;
    }

    public void execute(TextData textData) {
        if (command != null) {
            System.out.println("Enter the text you want to add");
            String textToAdd = inputReader.readNextLine();
            addTextCommand(textData, textToAdd, command.getNumericParams());
        } else {
            System.err.println("Command is missing the command information.");
        }
    }

    /**
     * Adds text to the paragraph that was put in with the ADD command
     *
     * @param textData  the current textData object
     * @param textToAdd new text that is added
     * @param offset    paragraph number that was put in with the ADD command
     * @author weberph5
     */
    private void addTextCommand(TextData textData, String textToAdd, Integer offset) {
        final boolean successFull = textData.insertTextAt(offset, textToAdd);
        if (!successFull) {
            System.err.println("Adding text was not successful. Paragraph number is invalid");
        }
    }
}
