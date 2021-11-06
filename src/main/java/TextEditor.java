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

    /**
     * Starts the Text Editor and keeps it running
     */
    public void startEdit() {
        System.out.println("***********************************");
        System.out.println("* Welcome to the best TextEditor! *");
        System.out.println("***********************************");
        commands.showCommands();
        isRunning = true;
        while (isRunning) {
            System.out.println("Please enter a command:");
            String command = inputReader.readNextCommandInput();
            executeCommand(command);
        }
    }

    private void executeCommand(String enteredCommand) {
        final String[] commandWithParams = enteredCommand.split("\\s+");

        //Check if length either one or three and check if second split is only numbers or not
        //Careful there are commands with 2 verbes

        final Command command = Command.getCommandByRepresentation(commandWithParams[0]);
        if (command != null) {
            switch (command) {
                case ADD:
                    break;
                case DEL:
                    break;
                case DUMMY:
                    commands.executeDummyCommand(textData);
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
                    System.out.println("Enter the paragraph number in which your word / text appears. If it's on the last paragraph, type in 0");
                    int paragraphNumber = inputReader.readNextInt();
                    System.out.println("Write the word / text you want to replace it with.");
                    String newText = inputReader.readNextTextString();
                    commands.executeReplaceCommand(textData, textToReplace, paragraphNumber, newText);
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