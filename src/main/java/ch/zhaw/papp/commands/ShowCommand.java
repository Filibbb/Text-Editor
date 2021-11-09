package ch.zhaw.papp.commands;

/**
 * Class for the Show Commands Command
 *
 * @author abuechi
 * @version 1.0.0
 */
public class ShowCommand {

    private ShowCommand() {
    }

    /**
     * Shows a list and description of all available commands.
     *
     * @author weberph5
     */
    public static void showCommands() {
        System.out.println("Available Commands (Case sensitive!):");
        System.out.println("");
        for (Commands commands : Commands.values()) {
            System.out.println(commands.getCommandInfo());
        }
        System.out.println("");
    }
}
