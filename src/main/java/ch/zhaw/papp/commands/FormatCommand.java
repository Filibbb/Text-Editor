package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

import java.util.ArrayList;
import java.util.List;

public class FormatCommand {
    private List<String> formattedParagraphs = new ArrayList<>();

    private void formatFix(TextData textData, int userParagraphWishLength) {
        List<String> text = textData.getParagraphs();
        int paragraphIndexOfNewText = 0;
        for (int paragraphIndexOfOriginalText = 0; paragraphIndexOfOriginalText < text.size(); paragraphIndexOfOriginalText++) {
            String[] oldParagraphWords = text.get(paragraphIndexOfOriginalText).split(" ");
            formattedParagraphs.add(oldParagraphWords[0]);

            //for(int paragraphIndexOfNewText = 0; paragraphIndexOfNewText < formattedParagraphs.size(); paragraphIndexOfNewText++){

            for (int WordOfOriginalText = 1; WordOfOriginalText < oldParagraphWords.length; WordOfOriginalText++) {
                int spaceNeeded = oldParagraphWords[WordOfOriginalText].length() + 1; //+1 because of space between words.
                int freeSpaceInFormattedParagraph = userParagraphWishLength - formattedParagraphs.get(paragraphIndexOfNewText).length();
                boolean spaceLeftInParagraphOfFormattedText = true;
                while (spaceLeftInParagraphOfFormattedText) {
                    if (spaceNeeded <= freeSpaceInFormattedParagraph) {
                        String mergedNewParagraph = formattedParagraphs.get(paragraphIndexOfNewText) + " " + oldParagraphWords[WordOfOriginalText];
                        formattedParagraphs.add(paragraphIndexOfNewText, mergedNewParagraph);
                    } else {
                        formattedParagraphs.add(oldParagraphWords[WordOfOriginalText]);
                    }
                    spaceLeftInParagraphOfFormattedText = spaceNeeded <= freeSpaceInFormattedParagraph;
                    paragraphIndexOfNewText++;
                }
            }
        }
    }

    private void formatRaw() {
        formattedParagraphs = new ArrayList<>();

    }
}
