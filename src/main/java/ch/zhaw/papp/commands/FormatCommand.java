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

            //for(int paragraphIndexOfNewText = 0; paragraphIndexOfNewText < formattedParagraphs.size(); paragraphIndexOfNewText++){

            for (int WordOfOriginalText = 1; WordOfOriginalText < oldParagraphWords.length; WordOfOriginalText++) {
                boolean spaceLeftInParagraphOfFormattedText = checkIfSpaceLeftInParagraph(oldParagraphWords[WordOfOriginalText].length() , userParagraphWishLength, formattedParagraphs.get(paragraphIndexOfNewText).length());
                if (spaceLeftInParagraphOfFormattedText) {
                    while (spaceLeftInParagraphOfFormattedText) {
                        String mergedNewParagraph = formattedParagraphs.get(paragraphIndexOfNewText) + " " + oldParagraphWords[WordOfOriginalText];
                        formattedParagraphs.set(paragraphIndexOfNewText, mergedNewParagraph);
                        spaceLeftInParagraphOfFormattedText = checkIfSpaceLeftInParagraph(oldParagraphWords[WordOfOriginalText].length() , userParagraphWishLength, formattedParagraphs.get(paragraphIndexOfNewText).length());
                    }
                } else {
                    formattedParagraphs.add(oldParagraphWords[WordOfOriginalText]);
                    paragraphIndexOfNewText++;
                }
            }
        }
        /*
        //Nur für test, vor dem print implement.
        for (String paragraph : formattedParagraphs) {
            System.out.println(paragraph);
        }*/
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
