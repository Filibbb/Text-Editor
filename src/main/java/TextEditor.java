/**
 * Contains the Text Editor life cycle
 * @author weberph5
 * @version 1.0.0
 */

public class TextEditor {

    private boolean isRunning = true;

    public TextEditor() {
        }

    public void start(){
        printIntroduction();
        while (isRunning){
            editText();
        }
    }

    private void printIntroduction(){
        System.out.println("Welcome to the TextEditor. Type GIMMEDACOMMANDS to get a list of available commands");
    }

    private void editText(){
        //ADD INPUT HANDLER HERE
    }
}


