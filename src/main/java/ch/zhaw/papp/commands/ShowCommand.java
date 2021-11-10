package ch.zhaw.papp.commands;

/**
 * Utility class for the ShowCommand command
 *
 * @author weberph5
 * @version 1.0.0
 */
public class ShowCommand {

    /**
     * Shows a list and description of all available commands.
     *
     * @author weberph5
     */
    public void execute() {
        System.out.println("Available Commands (Case sensitive!):");
        System.out.println("");
        for (Commands commands : Commands.values()) {
            System.out.println(commands.getCommandInfo());
        }
        System.out.println("");
    }
}
