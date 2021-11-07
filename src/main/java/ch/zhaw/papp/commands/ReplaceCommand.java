package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;
import ch.zhaw.papp.CommandHandler;

/**
 * replaces a word depending on the user's request, in the last line or in the desired line.
 * @author fupat002
 */
public class ReplaceCommand {
    private static final CommandHandler commandHandler = new CommandHandler();

    /**
     * Executes the replacement commands.
     * Depending on the user's preference, in the last line or in the desired line.
     *
     * @param text            the class that contains the text
     * @param textToReplace   the text / word that needs to be replaced
     * @param command         the entered command
     * @param newText         the text / word to replace it with
     */
    public static void replaceCommand(TextData text, String textToReplace, String newText, Command command) {
        int paragraph = 0;
        if(!text.getParagraphs().isEmpty()){
            if(command.hasParams()){
                paragraph = command.getNumericParams();
                if(text.isValidParagraph(paragraph)){
                    text.replaceText(textToReplace, paragraph, newText);
                }else{
                    System.out.println("Your text doesn't contain that much paragraphs.");
                    System.out.println("Select a paragraph in your text range.");
                    System.out.println("Number of lines: " + text.getParagraphs().size());
                }
            }else{
                text.replaceText(textToReplace, null, newText);
            }
        }else{
            System.err.println("There is no text. Add some with the commands below.");
            commandHandler.showCommands();
        }
    }
}
