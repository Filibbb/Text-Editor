import java.util.*;


public class Commands {
    private static final String dummyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sed quam sit amet ex dapibus egestas vel congue metus. Donec id eleifend nisi, vitae eleifend tortor. Quisque euismod vitae nisi fringilla dignissim. In aliquam finibus nisl vel euismod. Ut ac sodales elit. Proin rhoncus libero turpis, eget tempor nisl consequat sed. Proin tempus erat magna, vitae sodales arcu fringilla sit amet. Nunc elementum, velit placerat iaculis feugiat, lectus dolor dapibus velit, in maximus sapien felis at arcu. Nulla mollis suscipit egestas. Phasellus a volutpat libero, nec tincidunt tortor. Aenean mattis ligula eu efficitur ultricies. Vestibulum ac nibh sodales, venenatis sapien vel, maximus nisi. Curabitur feugiat dictum tortor, a hendrerit urna tincidunt vitae.";
    private final Set<String> availableCommands = new HashSet<>();

    public Commands() {
        availableCommands.add("DUMMY");
        availableCommands.add("DEL");
        availableCommands.add("ADD");
        availableCommands.add("EXIT");
        availableCommands.add("FORMAT RAW");
        availableCommands.add("FORMAT FIX");
        availableCommands.add("INDEX");
        availableCommands.add("PRINT");
        availableCommands.add("REPLACE");
        availableCommands.add("SHOWCOMMANDS");
    }

    public void showCommands() {
        System.out.println("Available Commands:");
        System.out.println("ADD : Add Text");
        System.out.println("DEL (n) : Delete Paragraph n");
        System.out.println("PRINT : ");
        System.out.println("DUMMY : ");
        System.out.println("FORMAT RAW : ");
        System.out.println("FORMAT FIX : ");
        System.out.println("INDEX : ");
        System.out.println("REPLACE : ");
        System.out.println("EXIT : Exit TextEditor!");
    }

    public boolean isAvailableCommand(String commandToCheck) {
        return availableCommands.contains(commandToCheck);
    }

    public boolean executeDummyCommand(TextData text) {
        return text.insertTextAt(null, " " + dummyText);
    }

    public boolean executeDummyCommand(TextData text, int offset) {
        return text.insertTextAt(offset, " " + dummyText);
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
