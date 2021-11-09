package ch.zhaw.papp.commands;

/**
 * A wrapper object for handling commands and their related commands.
 *
 * @author abuechi
 * @version 1.0.0
 */
public class Command {
    private Commands command;
    private Integer numericParams;

    /**
     * Retrieves the command
     *
     * @return command of command enums
     * @author abuechi
     */
    public Commands getCommand() {
        return command;
    }

    /**
     * Sets the command out of the available commands
     *
     * @param command the commmand enum representing the command that was executed
     * @author abuechi
     */
    public void setCommand(Commands command) {
        this.command = command;
    }

    /**
     * Retrieves the optional params of the command
     *
     * @return params return the additional params
     * @author abuechi
     */
    public Integer getNumericParams() {
        return numericParams;
    }

    /**
     * Sets the optional params of the command
     *
     * @param numericParams number params
     * @author abuechi
     */
    public void setNumericParams(Integer numericParams) {
        this.numericParams = numericParams;
    }

    public boolean isValidCommand() {
        return command != null;
    }

    /**
     * Checks if command has params
     *
     * @return true if the command has params, false otherwise.
     */
    public boolean hasParams() {
        return numericParams != null;
    }
}
