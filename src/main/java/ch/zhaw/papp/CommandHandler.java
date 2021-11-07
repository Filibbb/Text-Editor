package ch.zhaw.papp;

import ch.zhaw.papp.commands.Command;
import ch.zhaw.papp.commands.CommandConverterUtil;
import ch.zhaw.papp.commands.Commands;
import ch.zhaw.papp.commands.DummyCommand;
import ch.zhaw.papp.commands.PrintCommand;
import ch.zhaw.papp.commands.ReplaceCommand;

/**
 * A class that handles all commands and makes sure the correct commands are executed.
 *
 * @author abuechi
 * @version 1.0.0
 */
public class CommandHandler {

    private final ConsoleInputReader inputReader = new ConsoleInputReader();

    /**
     * Shows a list and description of all available commands.
     *
     * @author weberph5
     */
    public void showCommands() {
        System.out.println("Available ch.zhaw.papp.commands.Commands (Case sensitive!):");
        System.out.println("");
        for (Commands commands : Commands.values()) {
            System.out.println(commands.getCommandInfo());
        }
        System.out.println("");
    }

    /**
     * Exits the texteditor program.
     *
     * @author weberph5
     */
    public void exitEditor() {
        System.out.println("Closing the ch.zhaw.papp.TextEditor. Bye.");
        inputReader.closeScanner();
        System.exit(1);
    }

    /**
     * Executes the command that was entered.
     *
     * @author abuechi
     */
    public void executeCommand(String enteredCommand, TextData textData) {
        final Command command = CommandConverterUtil.convertToCommand(enteredCommand);
        if (command.isValidCommand()) {
            execute(command, textData);
        } else {
            System.err.println("This command is not available. Please choose one below.");
            showCommands();
        }
    }

    private void execute(Command command, TextData textData) {
        switch (command.getCommand()) {
            case ADD:
                break;
            case DEL:
                break;
            case DUMMY:
                if (command.hasParams()) {
                    DummyCommand.executeDummyCommand(textData, command.getNumericParams());
                } else {
                    DummyCommand.executeDummyCommand(textData);
                }
                PrintCommand.print(textData);
                break;
            case EXIT:
                exitEditor();
                break;
            case INDEX:
                break;
            case PRINT:
                PrintCommand.print(textData);
                break;
            case REPLACE:
                System.out.println("Write the word / text you want to replace.");
                String textToReplace = inputReader.readNextTextString();
                System.out.println("Write the word / text you want to replace it with.");
                String newText = inputReader.readNextTextString();
                ReplaceCommand.executeReplaceCommand(textData, textToReplace,  newText, command);
                System.out.println();
                break;
            case FORMAT_FIX:
                break;
            case FORMAT_RAW:
                break;
            case SHOW_COMMANDS:
                showCommands();
                break;
            default:
                System.err.println("This command is not available. Please choose one below.");
                showCommands();
                break;
        }
    }
}
