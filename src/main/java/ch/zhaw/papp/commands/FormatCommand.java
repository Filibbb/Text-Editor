package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

import java.util.ArrayList;
import java.util.List;

public class FormatCommand {
    private List<String> formattedParagraphs = new ArrayList<>();

    public void formatFix(TextData textData, int userParagraphWishLength) {
        List<String> text = textData.getParagraphs();
        int paragraphIndexOfNewText = 0;
        for (int paragraphIndexOfOriginalText = 0; paragraphIndexOfOriginalText < text.size(); paragraphIndexOfOriginalText++) {
            String[] oldParagraphWords = text.get(paragraphIndexOfOriginalText).split(" ");
            formattedParagraphs.add(oldParagraphWords[0]);
            int wordOfOriginalText = 1;
            boolean spaceLeftInParagraphOfFormattedText = false;
            while(wordOfOriginalText < oldParagraphWords.length){
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

    public void formatRaw() {
        formattedParagraphs = new ArrayList<>();

    }

    public List<String> getFormattedParagraphs() {
        return formattedParagraphs;
    }

    private boolean checkIfSpaceLeftInParagraph(int lengthOfTextToAdd, int maxLength, int alreadyOccupied){
        int spaceNeeded = lengthOfTextToAdd + 1;
        int freeSpace = maxLength - alreadyOccupied;
        return spaceNeeded <= freeSpace;
    }
}
