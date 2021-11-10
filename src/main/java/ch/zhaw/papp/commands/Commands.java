package ch.zhaw.papp.commands;

/**
 * Command Enum to contain available commands, their description and their representation.
 *
 * @author abuechi
 * @version 1.0.0
 */
public enum Commands {
    DUMMY("DUMMY", "DUMMY (n) : Add a pre-programmed dummy text to paragraph n. n is optional. Text will be added to the end if n is not set."),
    DELETE("DEL", "DEL (n) : Delete Paragraph n. n is optional. Last paragraph will be deleted if n is not set"),
    ADD("ADD", "ADD (n) : Add Text to paragraph n. n is optional. Text will be added to the end if n is not set."),
    EXIT("EXIT", "EXIT : Exit ch.zhaw.papp.TextEditor!"),
    FORMAT_RAW("FORMAT RAW", "FORMAT RAW : Set format to raw with no fix column length with paragraph numbers."),
    FORMAT_FIX("FORMAT FIX", "FORMAT FIX (b) : Set format to a fix column length b"),
    INDEX("INDEX", "INDEX : Prints an index of all words starting with an uppercase letter and exist more often than 3 times in all paragraphs."),
    PRINT("PRINT", "PRINT : Print all text in the currently set format."),
    REPLACE("REPLACE", "REPLACE (n): Search and replace a string in paragraph n. n is optional. If n is not set search and replace will be done in the last paragraph."),
    SHOW_COMMANDS("SHOW COMMANDS", "SHOW COMMANDS : Show list of available commands.");

    private final String representation;
    private final String commandInfo;

    /**
     * The enum constructor in order to save the related values to the enums.
     *
     * @param representation the command representation
     * @param commandInfo    the description on what the command does
     */
    Commands(String representation, String commandInfo) {
        this.representation = representation;
        this.commandInfo = commandInfo;
    }

    /**
     * @param commandRepresentation the string representing the command
     * @return the command enum
     * @author abuechi
     */
    public static Commands getCommandByRepresentation(final String commandRepresentation) {
        for (Commands value : Commands.values()) {
            if (value.representation.equals(commandRepresentation)) {
                return value;
            }
        }
        return null;
    }

    /**
     * @return command information / description
     * @author abuechi
     */
    public String getCommandInfo() {
        return commandInfo;
    }
}
