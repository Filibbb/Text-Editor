package ch.zhaw.papp;

import static ch.zhaw.papp.commands.ShowCommand.showCommands;

/**
 * Contains the Text Editor life cycle
 *
 * @author weberph5
 * @version 1.0.0
 */

public class TextEditor {
    private final ConsoleInputReader inputReader = new ConsoleInputReader();
    private final CommandHandler commandHandler = new CommandHandler();
    private final TextData textData = new TextData();

    /**
     * Starts the Text Editor and keeps it running
     *
     * @author weberph5
     */
    public void startEdit() {
        System.out.println("***********************************");
        System.out.println("* Welcome to the best TextEditor! *");
        System.out.println("***********************************");
        showCommands();
        while (true) { //exits when using the exit command. Otherwise application won't stop.
            System.out.println("Please enter a command:");
            String command = inputReader.readNextLine();
            commandHandler.executeCommand(command, textData);
        }
    }
}