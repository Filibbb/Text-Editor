package ch.zhaw.papp.commands;

/**
 * The Class for the exit command
 *
 * @author abuechi
 * @version 1.0.0
 */
public class ExitCommand {

    private ExitCommand() {
    }

    /**
     * Exits the TextEditor program.
     *
     * @author weberph5
     */
    public static void exitEditor() {
        System.out.println("Closing the TextEditor. Bye.");
        System.exit(1);
    }
}
