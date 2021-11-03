import java.util.ArrayList;
import java.util.List;

/**
 * A wrapper object that contains all operations on a text.
 * @author abuechi
 */
public class TextData {
    private final List<String> paragraphs;

    /**
     * Creates a new TextData Object with an empty paragraph list.
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

    private int convertParagraphToIndex(int paragraph) {
        return paragraph - 1;
    }

    private boolean isValidParagraph(Integer paragraphNumber) {
        return paragraphNumber != null && (paragraphNumber > 0 || paragraphNumber < paragraphs.size());
    }

    /**
     *Replaces a word in the last paragraph
     * @param textToReplaced the text that has to be replaced
     * @param newText the text that replaces the old text
     * @author fupat002
     */
    public void replaceAtLastParagraph(String textToReplaced, String newText){
        int numberOfLastParagraph = convertParagraphToIndex(paragraphs.size());
        if(containsWordAtParagraph(textToReplaced, numberOfLastParagraph)){
            paragraphs.set(numberOfLastParagraph, newText);
        }else{
            System.err.println("Your replacement word is not in this line. Check it out and try again.");
        }
    }

    /**
     *Replaces a word in the chosen paragraph
     * @param textToReplace the text that has to be replaced
     * @param paragraph the paragraph that contains the word that has to be replaced
     * @param newText the text that replaces the old text
     * @author fupat002
     */
    public void replaceAtVariableParagraph(String textToReplace, int paragraph ,String newText){
        if(containsWordAtParagraph(textToReplace, paragraph)){
            paragraphs.set(paragraph, newText);
        }else{
            System.err.println("Your replacement word is not in this line. Check it out and try again.");
        }
    }

    private boolean containsWordAtParagraph(String word, int paragraph){
        String paragraphText = paragraphs.get(paragraph);
        return paragraphText.contains(word);
    }
}
