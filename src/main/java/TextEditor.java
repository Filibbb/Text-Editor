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

    public TextEditor() {
    }

    /**
     *  Starts the Text Editor and keeps it running
     */
    public void start() {
        System.out.println("***********************************");
        System.out.println("* Welcome to the best TextEditor! *");
        System.out.println("***********************************");
        commands.showCommands();
        boolean isRunning = true;
        while (isRunning) {
            editText();
        }
        inputReader.closeScanner();
    }

    private void editText() {
        System.out.println("Please enter a command:");
        String command = inputReader.readNextString();
        executeCommand(command);
    }

    private void executeCommand(String command){
        if(commands.isAvailableCommand(command)){
            if(command.equals("DUMMY")){
                //Execute DUMMY
            }else if (command.equals("ADD")){
                //Execute ADD
            }else if (command.equals("PRINT")){
                commands.print(textData);
            }else if (command.equals("REPLACE")){
                System.out.println("Write the word / text you want to replace.");
                String textToReplace = inputReader.readNextString();
                System.out.println("Enter the paragraph number in which your word / text appears. If it's on the last paragraph, type in 0");
                int paragraphNumber = inputReader.readNextInt();
                System.out.println("Write the word / text you want to replace it with.");
                String newText = inputReader.readNextString();
                commands.executeReplaceCommand(textData,textToReplace, paragraphNumber, newText);
            }
        }else{
            System.err.println("This command is not available. Please choose one below.");
            commands.showCommands();
        }

    }
}


