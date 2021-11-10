package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to handle the formatting
 *
 * @author fupat002
 * @version 1.0.0
 */
public class Formatter {
    private List<String> formattedParagraphs = new ArrayList<>();
    private Integer userParagraphWishLength;

    /**
     * Defines the column width of the print text
     *
     * @param paragraphLength the maximum length that the paragraph may have after formatting
     * @author fupat002
     */
    public void formatFixCommand(int paragraphLength) {
        this.userParagraphWishLength = paragraphLength;
    }

    /**
     * Executes the format fix command with the desired maximal paragraph length.
     *
     * @param textData the current TextData object
     * @author fupat002.
     */
    public void executeFormatFixCommand(TextData textData) {
        if (userParagraphWishLength != null) {
            formatFix(textData);
        }
    }

    /**
     * Resets the format back to the original format.
     *
     * @author fupat002
     */
    public void formatRaw() {
        userParagraphWishLength = null;
    }

    /**
     * Get formatted paragraphs
     *
     * @return formatted paragraphs
     * @author fupat002
     */
    public List<String> getFormattedParagraphs() {
        return formattedParagraphs;
    }

    /**
     * Get the desired paragraph length
     *
     * @return desired paragraph length
     * @author fupat002
     */
    public Integer getUserParagraphWishLength() {
        return userParagraphWishLength;
    }

    private void formatFix(TextData textData) {
        checkIsAlreadyFormatted();
        List<String> text = textData.getParagraphs();
        int paragraphIndexOfNewText = 0;
        for (int paragraphIndexOfOriginalText = 0; paragraphIndexOfOriginalText < text.size(); paragraphIndexOfOriginalText++) {
            String[] oldParagraphWords = text.get(paragraphIndexOfOriginalText).split(" ");
            formattedParagraphs.add(oldParagraphWords[0]);
            int wordOfOriginalText = 1;
            if (paragraphIndexOfOriginalText != 0) {
                paragraphIndexOfNewText++;
            }
            boolean spaceLeftInParagraphOfFormattedText = false;
            while (wordOfOriginalText < oldParagraphWords.length) {
                spaceLeftInParagraphOfFormattedText = checkIfSpaceLeftInParagraph(oldParagraphWords[wordOfOriginalText].length(), userParagraphWishLength, formattedParagraphs.get(paragraphIndexOfNewText).length());
                if (spaceLeftInParagraphOfFormattedText) {
                    String mergedNewParagraph = formattedParagraphs.get(paragraphIndexOfNewText) + " " + oldParagraphWords[wordOfOriginalText];
                    formattedParagraphs.set(paragraphIndexOfNewText, mergedNewParagraph);
                } else {
                    formattedParagraphs.add(oldParagraphWords[wordOfOriginalText]);
                    paragraphIndexOfNewText++;
                }
                wordOfOriginalText++;
            }
        }
    }

    private boolean checkIfSpaceLeftInParagraph(int lengthOfTextToAdd, int maxLength, int alreadyOccupied) {
        int spaceNeeded = lengthOfTextToAdd + 1;
        int freeSpace = maxLength - alreadyOccupied;
        return spaceNeeded <= freeSpace;
    }

    private void checkIsAlreadyFormatted() {
        if (!formattedParagraphs.isEmpty()) {
            formattedParagraphs = new ArrayList<>();
        }
    }
}
