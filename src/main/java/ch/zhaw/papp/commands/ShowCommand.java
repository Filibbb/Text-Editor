package ch.zhaw.papp.commands;

/**
 * Command class for the ShowCommand command
 *
 * @author abuechi
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
