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
     * @param textToReplace the text that has to be replaced
     * @param newText the text that replaces the old text
     * @author fupat002
     */
    public void replaceInLastParagraph(String textToReplace, String newText){
        int numberOfLastParagraph = convertParagraphToIndex(paragraphs.size());
        String oldParagraphText = paragraphs.get(numberOfLastParagraph);
        if(containsWordAtParagraph(textToReplace, numberOfLastParagraph)){
            String newParagraphText = oldParagraphText.replace(textToReplace, newText);
            paragraphs.set(numberOfLastParagraph, newParagraphText);
        }else{
            System.err.println("Your replacement word is not in this line. Check it out and try again.");
        }
    }

    /**
     *Replaces a word in the chosen paragraph
     * @param textToReplace the text that has to be replaced
     * @param paragraphNumber the paragraph that contains the word that has to be replaced
     * @param newText the text that replaces the old text
     * @author fupat002
     */
    public void replaceInVariableParagraph(String textToReplace, int paragraphNumber ,String newText){
        int paragraph = convertParagraphToIndex(paragraphNumber);
        String oldParagraphText = paragraphs.get(paragraph);
        if(containsWordAtParagraph(textToReplace, paragraph)){
            String newParagraphText = oldParagraphText.replace(textToReplace, newText);
            paragraphs.set(paragraph, newParagraphText);
        }else{
            System.err.println("Your replacement word \"" + textToReplace + "\" is not in this line. Check it out and try again.");
        }
    }

    private boolean containsWordAtParagraph(String word, int paragraph){
        String paragraphText = paragraphs.get(paragraph);
        return paragraphText.contains(word);
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }
}
