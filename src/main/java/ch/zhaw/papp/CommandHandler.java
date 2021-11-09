package ch.zhaw.papp;

import ch.zhaw.papp.commands.AddTextCommand;
import ch.zhaw.papp.commands.Command;
import ch.zhaw.papp.commands.DeleteCommand;
import ch.zhaw.papp.commands.DummyCommand;

import static ch.zhaw.papp.commands.CommandConverterUtil.convertToCommand;
import static ch.zhaw.papp.commands.ExitCommand.exitEditor;
import static ch.zhaw.papp.commands.PrintCommand.print;
import static ch.zhaw.papp.commands.ReplaceCommand.replaceCommand;
import static ch.zhaw.papp.commands.ShowCommand.showCommands;

/**
 * A class that handles all commands and makes sure the correct commands are executed.
 *
 * @author abuechi
 * @version 1.0.0
 */
public class CommandHandler {
    private final ConsoleInputReader inputReader = new ConsoleInputReader();

    /**
     * Executes the command that was entered.
     *
     * @param enteredCommand user inputted command as string that should match with a representation of a string
     * @param textData       the textdata object
     * @author abuechi
     */
    public void executeCommand(String enteredCommand, TextData textData) {
        final Command command = convertToCommand(enteredCommand);
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
                final AddTextCommand addTextCommand = new AddTextCommand(command);
                addTextCommand.execute(textData);
                print(textData);
                break;
            case DELETE:
                final DeleteCommand deleteCommand = new DeleteCommand(command);
                deleteCommand.execute(textData);
                break;
            case DUMMY:
                final DummyCommand dummyCommand = new DummyCommand(command);
                dummyCommand.execute(textData);
                print(textData);
                break;
            case EXIT:
                exitEditor();
                break;
            case INDEX:
                break;
            case PRINT:
                print(textData);
                break;
            case REPLACE:
                System.out.println("Write the word / text you want to replace.");
                String textToReplace = inputReader.readNextLine();
                System.out.println("Write the word / text you want to replace it with.");
                String newText = inputReader.readNextLine();
                replaceCommand(textData, textToReplace, newText, command);
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
