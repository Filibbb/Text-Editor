package ch.zhaw.papp.commands;

import static ch.zhaw.papp.ConsoleInputReader.closeScanner;

/**
 * The Class for the exit command
 *
 * @author abuechi
 * @version 1.0.0
 */
public class ExitCommand {

    /**
     * Exits the TextEditor program.
     *
     * @author weberph5
     */
    public void execute() {
        System.out.println("Closing the TextEditor. Bye.");
        closeScanner();
        System.exit(1);
    }
}
