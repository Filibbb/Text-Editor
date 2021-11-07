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
