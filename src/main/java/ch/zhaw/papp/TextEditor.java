package ch.zhaw.papp;

import ch.zhaw.papp.commands.Command;
import ch.zhaw.papp.commands.FormatCommand;
import ch.zhaw.papp.commands.ShowCommand;

import static ch.zhaw.papp.ConsoleInputReader.readNextLine;
import static ch.zhaw.papp.commands.CommandConverterUtil.convertToCommand;

/**
 * Contains the Text Editor life cycle
 *
 * @author weberph5
 * @version 1.0.0
 */

public class TextEditor {
    private final CommandHandler commandHandler = new CommandHandler();
    private final TextData textData = new TextData();
    private FormatCommand formatCommand = new FormatCommand();

    /**
     * Starts the Text Editor and keeps it running
     *
     * @author weberph5
     */
    public void startEditing() {
        System.out.println("***********************************");
        System.out.println("* Welcome to the best TextEditor! *");
        System.out.println("***********************************");
        final ShowCommand showCommand = new ShowCommand();
        showCommand.execute();
        do { //exits when using the exit command. Otherwise application won't stop.
            System.out.println("Please enter a command:");
            String inputtedText = readNextLine();
            if (!inputtedText.equals("")) {
                final Command command = convertToCommand(inputtedText);
                if (command.isValidCommand()) {
                    commandHandler.executeCommand(command, textData);
                } else {
                    System.err.println("This command is not available. Please choose one. Use 'SHOW COMMANDS' for available commands.");
                }
            }
        } while (true);
    }
}