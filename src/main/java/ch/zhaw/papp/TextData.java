package ch.zhaw.papp;

import java.util.ArrayList;
import java.util.List;

/**
 * A wrapper object that contains all operations on a text.
 *
 * @author abuechi
 * @version 1.0.0
 */
public class TextData {
    private static final String ALLOWED_TEXT_ELEMENTS = "[a-zA-Z0-9. ,:;!?’()\"%@+*\\-\\[\\]{}/&#$]*";
    private final List<String> paragraphs = new ArrayList<>();

    /**
     * @param paragraphNumber null or a specified index of the paragraph
     * @param text            the text that should be inputted at the specified paragraphNumber OR the end of the file
     * @return a boolean value representing the success of the operation
     */
    public boolean insertTextAt(Integer paragraphNumber, String text) {
        if (isValidText(text)) {
            final Integer paragraphIndex = convertParagraphToIndex(paragraphNumber);
            if (isValidParagraph(paragraphNumber)) {
                paragraphs.add(paragraphIndex, text);
            } else {
                paragraphs.add(text);
            }
            return true;
        } else {
            System.err.println("Your text doesn't just contain letters, numbers, spaces or punctuation marks such as .,:;-!?’()\"%@+*[]{}/&#$");
        }
        return false;
    }

    /**
     * Translates the given paragraph number to index and deletes the values in that index
     *
     * @param paragraphNumber the paragraph number provided by the Delete Command (can also be null)
     * @return boolean value about success of deletion
     * @author weberph5
     */
    public boolean deleteTextAt(Integer paragraphNumber) {
        if (!paragraphs.isEmpty()) {
            Integer paragraphIndex = paragraphOrLastIndex(paragraphNumber);
            paragraphs.remove(paragraphIndex.intValue());
            return true;
        }
        return false;
    }

    /**
     * replaces text with another in a specific paragraph
     * if paragraphNumber is null then it replaces the word in the last paragraph
     *
     * @param textToReplace   the text / word that needs to be replaced
     * @param paragraphNumber the paragraph that contains the text / word that needs to be replaced
     * @param newText         the text / word to replace it with
     * @author fupat002
     */
    public void replaceText(String textToReplace, Integer paragraphNumber, String newText) {
        if (isValidText(textToReplace)) {
            final Integer paragraphOrLast = paragraphOrLastIndex(paragraphNumber);
            if (containsWordAtParagraph(textToReplace, paragraphOrLast)) {
                String oldParagraphText = paragraphs.get(paragraphOrLast);
                String newParagraphText = oldParagraphText.replace(textToReplace, newText);
                paragraphs.set(paragraphOrLast, newParagraphText);
            } else {
                System.err.println("Your replacement word \"" + textToReplace + "\" is not in this line or your paragraph was invalid. Check it out and try again.");
            }
        } else {
            System.err.println("Your text doesn't just contain letters, numbers, spaces or punctuation marks such as .,:;-!?’()\"%@+*[]{}/&#$");
        }
    }

    /**
     * checks whether the paragraph contains a word
     *
     * @param word      the word you are looking for
     * @param paragraph the number of the paragraph
     * @return true if the paragraph contains the word
     * @author fupat002
     */
    public boolean containsWordAtParagraph(String word, Integer paragraph) {
        String paragraphText = paragraphs.get(paragraph);
        return paragraphText.contains(word);

    }

    private boolean isValidParagraph(Integer paragraphNumber) {
        return paragraphNumber != null && paragraphNumber >= 0 && (paragraphNumber < paragraphs.size() || paragraphNumber == 1);
    }

    /**
     * Getter method to obtain all saved paragraphs
     *
     * @return all paragraphs
     * @author fupat002
     */
    public List<String> getParagraphs() {
        return paragraphs;
    }

    private Integer paragraphOrLastIndex(Integer paragraph) {
        final Integer paragraphToIndex = convertParagraphToIndex(paragraph);
        if (isValidParagraph(paragraphToIndex)) {
            return paragraphToIndex;
        } else {
            return paragraphs.size() - 1;
        }
    }

    private Integer convertParagraphToIndex(Integer paragraph) {
        if (paragraph == null) {
            return this.paragraphs.size();
        } else if (paragraph == 0) {
            return 0;
        } else if (paragraph > 0) {
            return paragraph - 1;
        } else {
            return null;
        }
    }

    private boolean isValidText(String userTextInput) {
        return userTextInput.matches(ALLOWED_TEXT_ELEMENTS);
    }
}
