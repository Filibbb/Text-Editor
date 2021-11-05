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
            switch(command){
                case "ADD":
                    //Execute ADD
                    textData.insertTextAt(null, "Hallo Welt!");
                    break;
                case "DEL":
                    //Execute DEL
                    break;
                case "PRINT":
                    commands.print(textData);
                    break;
                case "DUMMY":
                    //Execute DUMMY
                    break;
                case "FORMAT RAW":
                    //Execute FORMAT RAW
                    break;
                case "FORMAT FIX":
                    //Execute FORMAT FIX
                    break;
                case "INDEX":
                    //Execute INDEX
                    break;
                case "REPLACE":
                    System.out.println("Write the word / text you want to replace.");
                    String textToReplace = inputReader.readNextString();
                    System.out.println("Enter the paragraph number in which your word / text appears. If it's on the last paragraph, type in 0");
                    int paragraphNumber = inputReader.readNextInt();
                    System.out.println("Write the word / text you want to replace it with.");
                    String newText = inputReader.readNextString();
                    commands.executeReplaceCommand(textData,textToReplace, paragraphNumber, newText);
                    break;
                case "EXIT":
                    //Execute EXIT
                    break;
                case "SHOWCOMMANDS":
                    commands.showCommands();
                    break;
            }
        }else{
            System.err.println("This command is not available. Please choose one below.");
            commands.showCommands();
        }

    }
}


