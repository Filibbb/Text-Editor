package ch.zhaw.papp.commands;

/**
 * Utility Class to convert a user input into a command class.
 *
 * @author abuechi
 * @version 1.0.0
 */
public class CommandConverterUtil {
    public static final String TWO_WORD_COMMAND_WITHOUT_PARAMS = "^[a-zA-Z]+( [a-zA-Z]+)?$";

    private CommandConverterUtil() {
    }

    /**
     * Converts the string text into a command object for use with params.
     *
     * @param userInput the inputted text that should represent a valid command
     * @return a command object with its name and params. Null on command if no command was found or params were invalid.
     * @author abuechi
     */
    public static Command convertToCommand(String userInput) {
        final String formattedCommandString = userInput.trim();
        if (formattedCommandString.matches(TWO_WORD_COMMAND_WITHOUT_PARAMS)) {
            return createCommandWithoutParams(formattedCommandString);
        } else {
            return createCommandWithParams(formattedCommandString);
        }
    }

    private static Command createCommandWithoutParams(String userInput) {
        final Command command = new Command();
        command.setCommand(Commands.getCommandByRepresentation(userInput));
        return command;
    }

    private static Command createCommandWithParams(String userInput) {
        final Command command = new Command();
        final Integer numericArgument = getNumericArgument(userInput);
        if (numericArgument == null) {
            command.setCommand(null);
        } else {
            command.setNumericParams(numericArgument);
            String commandName = userInput.replace(numericArgument.toString(), "").trim();
            command.setCommand(Commands.getCommandByRepresentation(commandName));
        }
        return command;
    }

    private static Integer getNumericArgument(String userInput) {
        try {
            final String[] userInputWords = userInput.split("\\s+");
            final String argument = userInputWords[userInputWords.length - 1];
            return Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            System.err.println("Argument could not be converted to number.");
            return null;
        }
    }
}
