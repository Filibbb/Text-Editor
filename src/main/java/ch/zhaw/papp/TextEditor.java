package ch.zhaw.papp;

import ch.zhaw.papp.commands.Command;
import ch.zhaw.papp.commands.Formatter;
import ch.zhaw.papp.commands.ShowCommand;

import static ch.zhaw.papp.ConsoleInputReader.readNextLine;
import static ch.zhaw.papp.commands.CommandConverterUtil.convertToCommand;

/**
 * Wrapper class that contains the TextEditor life cycle
 *
 * @author weberph5
 * @version 1.0.0
 */

public class TextEditor {
    private final CommandHandler commandHandler = new CommandHandler();
    private final TextData textData = new TextData();
    private final Formatter formatter = new Formatter();

    /**
     * Starts the Text Editor and keeps it running until the exit command is executed
     *
     * @author weberph5
     */
    public void startEditing() {
        System.out.println("***********************************");
        System.out.println("* Welcome to the best TextEditor! *");
        System.out.println("***********************************");
        final ShowCommand showCommand = new ShowCommand();
        showCommand.execute();
        do {
            System.out.println("Please enter a command:");
            String inputtedText = readNextLine();
            if (!inputtedText.equals("")) {
                final Command command = convertToCommand(inputtedText);
                if (command.isValidCommand()) {
                    commandHandler.executeCommand(command, textData, formatter);
                } else {
                    System.err.println("Command input is was invalid. Use 'SHOW COMMANDS' for available valid commands.");
                }
            }
        } while (true);
    }
}