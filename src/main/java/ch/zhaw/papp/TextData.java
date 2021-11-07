package ch.zhaw.papp;

import java.util.ArrayList;
import java.util.List;

/**
 * A wrapper object that contains all operations on a text.
 * @author abuechi
 */
public class TextData {
    private final List<String> paragraphs;

    /**
     * Creates a new ch.zhaw.papp.TextData Object with an empty paragraph list.
     */
    public TextData() {
        this.paragraphs = new ArrayList<>();
    }

    /**
     * @param paragraphNumber null or a specified index of the paragraph
     * @param text the text that should be inputted at the specified paragraphNumber OR the end of the file
     * @return a boolean value representing the success of the operation
     */
    public boolean insertTextAt(Integer paragraphNumber, String text) {
        if (paragraphNumber == null) {
            paragraphs.add(text);
            return true;
        } else {
            if (isValidParagraph(paragraphNumber)) {
                paragraphs.add(convertParagraphToIndex(paragraphNumber), text);
                return true;
            }
            return false;
        }
    }

    /**
     * replaces text with another in a specific paragraph
     * if paragraphNumber is null then it replaces the word in the last paragraph
     * @param textToReplace     the text / word that needs to be replaced
     * @param paragraphNumber   the paragraph that contains the text / word that needs to be replaced
     * @param newText           the text / word to replace it with
     */
    public void replaceText(String textToReplace, Integer paragraphNumber , String newText){
        int paragraph;
        if(paragraphNumber != null){
            paragraph = convertParagraphToIndex(paragraphNumber);
        }else{
            paragraph = convertParagraphToIndex(paragraphs.size());
        }
        String oldParagraphText = paragraphs.get(paragraph);
        if(containsWordAtParagraph(textToReplace, paragraph)){
            String newParagraphText = oldParagraphText.replace(textToReplace, newText);
            paragraphs.set(paragraph, newParagraphText);
        }else{
            System.err.println("Your replacement word \"" + textToReplace + "\" is not in this line. Check it out and try again.");
        }
    }

    /**
     * checks whether the paragraph contains a word
     * @param word      the word you are looking for
     * @param paragraph the number of the paragraph
     * @return          true if the paragraph contains the word
     * @author          fupat002
     */
    public boolean containsWordAtParagraph(String word, int paragraph){
        String paragraphText = paragraphs.get(paragraph);
        return paragraphText.contains(word);
    }

    /**
     * checks if the parameter is a valid paragraph.
     * @param paragraphNumber   the paragraph number to check
     * @return                  true or false if it's a valid paragraph
     */
    public boolean isValidParagraph(Integer paragraphNumber) {
        return paragraphNumber != null && paragraphNumber > 0 && paragraphNumber <= paragraphs.size();
    }
    public List<String> getParagraphs() {
        return paragraphs;
    }

    private int convertParagraphToIndex(int paragraph) {
        return paragraph - 1;
    }
}
