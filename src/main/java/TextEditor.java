/**
 * Contains the Text Editor life cycle
 *
 * @author weberph5
 * @version 1.0.0
 */

public class TextEditor {
    ConsoleInputReader inputReader = new ConsoleInputReader();
    Commands commands = new Commands();
    TextData textData = new TextData();
    boolean isRunning;

    public TextEditor() {
    }

    /**
     * Starts the Text Editor and keeps it running
     */
    public void start() {
        System.out.println("***********************************");
        System.out.println("* Welcome to the best TextEditor! *");
        System.out.println("***********************************");
        commands.showCommands();
        isRunning = true;
        while (isRunning) {
            editText();
        }
    }

    private void editText() {
        System.out.println("Please enter a command:");
        String command = inputReader.readNextTextString();
        executeCommand(command);
    }

    private void executeCommand(String enteredCommand) {
        final String[] commandWithParams = enteredCommand.split(" +");

        //Check if length either one or three

        final Command command = Command.getCommandByRepresentation(commandWithParams[0]);
        if (command != null) {
            switch (command) {
                case ADD:
                    break;
                case DEL:
                    break;
                case DUMMY:
                    break;
                case EXIT:
                    isRunning = commands.exitEditor();
                    break;
                case INDEX:
                    break;
                case PRINT:
                    commands.print(textData);
                    break;
                case REPLACE:
                    System.out.println("Write the word / text you want to replace.");
                    String textToReplace = inputReader.readNextTextString();
                    System.out.println("Write the word / text you want to replace it with.");
                    String newText = inputReader.readNextTextString();
                    commands.executeReplaceCommand(textData, textToReplace, enteredCommand, newText);
                    break;
                case FORMAT_FIX:
                    break;
                case FORMAT_RAW:
                    break;
                case SHOW_COMMANDS:
                    break;
                default:
                    System.err.println("This command is not available. Please choose one below.");
                    commands.showCommands();
                    break;
            }
        } else {
            System.err.println("This command is not available. Please choose one below.");
            commands.showCommands();
        }
    }
}