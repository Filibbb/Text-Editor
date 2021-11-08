package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IndexCommand {

    public static void executeDummyCommand(TextData textData) {

    }

    public String printIndex(TextData text) {
        ArrayList<String> allTerms = saveTerms(new ArrayList<String>(text.getParagraphs()));
        ArrayList<String> termsWithOccurenceLessThanFour = getTermsWithMoreThanThreeOccurances(allTerms);
        HashMap<String, ArrayList<Integer>> map = allocateIndices(allTerms, termsWithOccurenceLessThanFour);
        String result = mapToString(map);
        return result;
    }

    private ArrayList<String> saveTerms(ArrayList<String> list) {
        ArrayList<String> allTerms = new ArrayList<>();
        for (String str : list) {
            String textWithoutPunctuationAndNumbers = str.replaceAll("\\p{Punct}[0-9]", "");
            String[] allWords = textWithoutPunctuationAndNumbers.split(" ");
            for (int i=0; i<allWords.length; i++) {
                if(allWords[i].length()>0 && Character.isUpperCase(allWords[i].charAt(0))) {
                    allTerms.add(allWords[i]);
                }
            }
        }
        return allTerms;
    }

    private ArrayList<String> getTermsWithMoreThanThreeOccurances(ArrayList<String> allTerms) {
        Collections.sort(allTerms);
        ArrayList<String> result = new ArrayList<String>();
        int counter = 1;
        for (int i = 0; i< allTerms.size()-1; i++) {
            if (allTerms.get(i).equals(allTerms.get(i+1))) {
                counter ++;
            } else{
                counter = 1;
            }
            if(counter == 4) {
                result.add(allTerms.get(i));
            }
        }
        return result;
    }

    private HashMap<String, ArrayList<Integer>> allocateIndices(ArrayList<String> list, ArrayList<String> result) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (String str: result) {
            ArrayList<Integer> indices = new ArrayList<Integer>();
            for (int i = 0; i< list.size(); i++) {
                if(list.get(i).equals(str)) {
                    indices.add(i+1);
                }
            }
            map.put(str, indices);
        }
        return map;
    }

    public String mapToString(HashMap<String, ArrayList<Integer>> map){
        String result = "";
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            result += key+"     \t\t";
            result += value.toString() +"\n";
        }
        return result;
    }
}