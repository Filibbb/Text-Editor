package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

import java.util.*;

/**
 * Contains the method to give out the index
 *
 * @author kuengpas
 * @version 1.0.0
 */
public class IndexCommand {

    /**
     * Executes the index command by counting all terms with capital letters, and assigning paragraphs to those terms
     * with mention of more than three.
     *
     * @param textData the class that contains the text for the index command.
     * @return word mentioned four or more times with respective paragraph
     * @author kuengpas
     */
    public String execute(TextData textData) {
        final ArrayList<String> allTerms = getAllTerms(textData.getParagraphs());
        final ArrayList<String> termsWithMoreThanThreeOccurrences = getTermsWithMoreThanThreeOccurrences(allTerms);
        final HashMap<String, ArrayList<Integer>> termsWithIndices = allocateIndices(textData, termsWithMoreThanThreeOccurrences);

        return getFormattedIndices(termsWithIndices);
    }

    private ArrayList<String> getAllTerms(List<String> paragraphs) {
        final ArrayList<String> allTerms = new ArrayList<>();
        for (String paragraph : paragraphs) {
            String textWithoutPunctuationAndNumbers = paragraph.replaceAll("[^a-zA-Z ]", "");
            final ArrayList<String> wordsFromParagraph = getWordsWithUpperCaseFromParagraph(textWithoutPunctuationAndNumbers);
            allTerms.addAll(wordsFromParagraph);
        }
        return allTerms;
    }

    private ArrayList<String> getWordsWithUpperCaseFromParagraph(String textWithoutPunctuationAndNumbers) {
        final ArrayList<String> allTerms = new ArrayList<>();
        String[] allWords = textWithoutPunctuationAndNumbers.split(" ");
        for (String allWord : allWords) {
            if (allWord.length() > 0 && Character.isUpperCase(allWord.charAt(0))) {
                allTerms.add(allWord);
            }
        }
        return allTerms;
    }

    private ArrayList<String> getTermsWithMoreThanThreeOccurrences(final ArrayList<String> allTerms) {
        Collections.sort(allTerms);
        final ArrayList<String> termsWithMoreThanThreeOccurrences = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < allTerms.size() - 1; i++) {
            if (allTerms.get(i).equals(allTerms.get(i + 1))) {
                counter++;
            } else {
                counter = 1;
            }
            if (counter == 4) {
                termsWithMoreThanThreeOccurrences.add(allTerms.get(i));
                counter = 0;
            }
        }
        return termsWithMoreThanThreeOccurrences;
    }

    private HashMap<String, ArrayList<Integer>> allocateIndices(TextData textData, final ArrayList<String> termsWithMoreThanThreeOccurrences) {
        HashMap<String, ArrayList<Integer>> termsWithIndices = new HashMap<>();
        for (String term : termsWithMoreThanThreeOccurrences) {
            termsWithIndices.put(term, getTermIndices(textData, term));
        }
        return termsWithIndices;
    }

    private ArrayList<Integer> getTermIndices(TextData textData, String term) {
        final ArrayList<Integer> indices = new ArrayList<>();
        final List<String> paragraphs = textData.getParagraphs();
        for (int i = 0; i < paragraphs.size(); i++) {
            if (paragraphs.get(i).contains(term)) {
                indices.add(i + 1);
            }
        }
        return indices;
    }

    private String getFormattedIndices(HashMap<String, ArrayList<Integer>> map) {
        String result = "";
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            result += entry.getKey() + "     \t\t";
            result += entry.getValue() + "\n";
        }
        return result;
    }
}