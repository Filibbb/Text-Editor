package ch.zhaw.papp;

import ch.zhaw.papp.commands.*;

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
     * Executes the replace commands
     *
     * @param text            the class that contains the text
     * @param textToReplace   the text / word that needs to be replaced
     * @param paragraphNumber the paragraph number (optional)
     * @param newText         the text / word to replace it with.
     */
    public void executeReplaceCommand(TextData text, String textToReplace, int paragraphNumber, String newText) {
        if (paragraphNumber == 0) {
            text.replaceInLastParagraph(textToReplace, newText);
        } else {
            text.replaceInVariableParagraph(textToReplace, paragraphNumber, newText);
        }
    }

    /**
     * Prints the whole text.
     *
     * @param textData the class that contains the text for the replacement
     * @author fupat002
     */
    public void print(TextData textData) {
        if (!textData.getParagraphs().isEmpty()) {
            for (String paragraph : textData.getParagraphs()) {
                System.out.println(paragraph);
            }
            System.out.println("--------- This line marks the end. It doesn't belong to the Text! ---------");
        } else {
            System.err.println("There is no text. Add some with the commands below.");
            showCommands();
        }
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
                print(textData);
                break;
            case EXIT:
                exitEditor();
                break;
            case INDEX:
                IndexCommand.executeDummyCommand(textData);
                break;
            case PRINT:
                print(textData);
                break;
            case REPLACE:
                System.out.println("Write the word / text you want to replace.");
                String textToReplace = inputReader.readNextTextString();
                System.out.println("Enter the paragraph number in which your word / text appears. If it's on the last paragraph, type in 0");
                int paragraphNumber = inputReader.readNextInt();
                System.out.println("Write the word / text you want to replace it with.");
                String newText = inputReader.readNextTextString();
                executeReplaceCommand(textData, textToReplace, paragraphNumber, newText);
                print(textData);
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
