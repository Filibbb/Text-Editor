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

    public Commands getCommand() {
        return command;
    }

    public void setCommand(Commands command) {
        this.command = command;
    }

    public Integer getNumericParams() {
        return numericParams;
    }

    public void setNumericParams(Integer numericParams) {
        this.numericParams = numericParams;
    }

    /**
     * Checks if a command is valid
     *
     * @return true if command is not null
     * @author abuechi
     */
    public boolean isValidCommand() {
        return command != null;
    }

    /**
     * Checks if command has params
     *
     * @return true if the command has params, false otherwise.
     * @author abuechi
     */
    public boolean hasParams() {
        return numericParams != null;
    }
}
