
/**
 * replaces a word depending on the user's request, in the last line or in the desired line.
 * @author fupat002
 */
public class ReplaceCommand {
    private final Commands commands = new Commands();

    /**
     * Executes the replacement commands.
     * Depending on the user's preference, in the last line or in the desired line.
     *
     * @param text            the class that contains the text
     * @param textToReplace   the text / word that needs to be replaced
     * @param command         the entered command
     * @param newText         the text / word to replace it with
     */
    public void executeReplaceCommand(TextData text, String textToReplace, String newText, String command) {
        int paragraph = 0;
        if(!text.getParagraphs().isEmpty()){
            if(command.matches("[A-Z ]+[0-9]+")){
                String[] numberSplit = command.split(" +");
                for (String splitElement : numberSplit) {
                    if (splitElement.matches("[0-9]+")) {
                        paragraph = Integer.parseInt(splitElement);
                    }
                }
                replaceInVariableParagraph(text, textToReplace, paragraph, newText);
            }else{
                replaceInLastParagraph(text, textToReplace, newText);
            }
        }else{
            System.err.println("There is no text. Add some with the commands below.");
            commands.showCommands();
        }
    }

    private void replaceInLastParagraph(TextData textData, String textToReplace, String newText){
        int numberOfLastParagraph = convertParagraphToIndex(textData.getParagraphs().size());
        String oldParagraphText = textData.getParagraphs().get(numberOfLastParagraph);
        if(textData.containsWordAtParagraph(textToReplace, numberOfLastParagraph)){
            String newParagraphText = oldParagraphText.replace(textToReplace, newText);
            textData.getParagraphs().set(numberOfLastParagraph, newParagraphText);
        }else{
            System.err.println("Your replacement word is not in this line. Check it out and try again.");
        }
    }

    private void replaceInVariableParagraph(TextData textData, String textToReplace, int paragraphNumber ,String newText){
        int paragraph = convertParagraphToIndex(paragraphNumber);
        String oldParagraphText = textData.getParagraphs().get(paragraph);
        if(textData.containsWordAtParagraph(textToReplace, paragraph)){
            String newParagraphText = oldParagraphText.replace(textToReplace, newText);
            textData.getParagraphs().set(paragraph, newParagraphText);
        }else{
            System.err.println("Your replacement word \"" + textToReplace + "\" is not in this line. Check it out and try again.");
        }
    }

    private int convertParagraphToIndex(int paragraph) {
        return paragraph - 1;
    }
}
