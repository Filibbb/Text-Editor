package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

import java.util.*;

public class IndexCommand {

    private IndexCommand() {
    }

    public static void executeIndexCommand(TextData textData) {
        String paragraph1 = "Wenn, Wenn, Wenn, Wenn, man das Wetter 30 Jahre lang beobachtet, die wichtigsten Daten aufschreibt und Mittelwerte daraus macht, "
                + "dann hat man ziemlich gut das Klima einer Region oder eben der Erde beschrieben. Das ist etwas anderes als das aktuelle "
                + "Wetter an einem bestimmten Ort.";
        String paragraph2 = "Deshalb ist es auch einfacher, das Klima in 20 Jahren zu beschreiben als das Wetter in 20 Tagen vorherzusagen. "
                + "Wie das nämlich an einem genauen Ort und zu einem bestimmten Zeitpunkt aussehen wird, ist unmöglich zu berechnen.";
        String paragraph3 = "Deshalb ist es auch einfacher, das Klima in 20 Jahren zu beschreiben als das Wetter in 20 Tagen vorherzusagen. "
                + "Wie das nämlich an einem genauen Ort und zu einem bestimmten Zeitpunkt aussehen wird, ist unmöglich zu berechnen.";
        String paragraph4 = "Wenn, Wenn, Wenn, Wenn, man das Wetter 30 Jahre lang beobachtet, die wichtigsten Daten aufschreibt und Mittelwerte daraus macht, "
                + "dann hat man ziemlich gut das Klima einer Region oder eben der Erde beschrieben. Das ist etwas anderes als das aktuelle "
                + "Wetter an einem bestimmten Ort.";
        textData.insertTextAt(1, paragraph1);
        textData.insertTextAt(2, paragraph2);
        textData.insertTextAt(3, paragraph3);
        textData.insertTextAt(4, paragraph4);

        ArrayList<String> termsWithMoreThanThreeOccurrences = getTermsWithMoreThanThreeOccurrences(textData);
        HashMap<String, ArrayList<Integer>> termsWithIndices = allocateIndices(textData, termsWithMoreThanThreeOccurrences);

        System.out.println(getFormattedIndices(termsWithIndices));
    }

    private static ArrayList<String> getAllTerms(List<String> paragraphs) {
        ArrayList<String> allTerms = new ArrayList<>();
        for (String paragraph : paragraphs) {
            String textWithoutPunctuationAndNumbers = paragraph.replaceAll("[^a-zA-Z ]", "");
            String[] allWords = textWithoutPunctuationAndNumbers.split(" ");
            for (String allWord : allWords) {
                if (allWord.length() > 0 && Character.isUpperCase(allWord.charAt(0))) {
                    allTerms.add(allWord);
                }
            }
        }
        return allTerms;
    }

    private static ArrayList<String> getTermsWithMoreThanThreeOccurrences(TextData textData) {
        ArrayList<String> allTerms = getAllTerms(textData.getParagraphs());
        Collections.sort(allTerms);
        ArrayList<String> termsWithMoreThanThreeOccurrences = new ArrayList<>();
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

    private static HashMap<String, ArrayList<Integer>> allocateIndices(TextData textData, ArrayList<String> termsWithMoreThanThreeOccurrences) {
        HashMap<String, ArrayList<Integer>> termsWithIndices = new HashMap<>();
        for (String term : termsWithMoreThanThreeOccurrences) {
            termsWithIndices.put(term, getTermIndices(textData, term));
        }
        return termsWithIndices;
    }

    private static ArrayList<Integer> getTermIndices(TextData textData, String term) {
        ArrayList<Integer> indices = new ArrayList<>();
        final List<String> paragraphs = textData.getParagraphs();
        for (int i = 0; i < paragraphs.size(); i++) {
            if (paragraphs.get(i).contains(term)) {
                indices.add(i + 1);
            }
        }
        return indices;
    }

    private static String getFormattedIndices(HashMap<String, ArrayList<Integer>> map) {
        String result = "";
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            result += entry.getKey() + "     \t\t";
            result += entry.getValue() + "\n";
        }
        return result;
    }
}