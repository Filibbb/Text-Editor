
/**
 * contains the method to print the text.
 * @author fupat002
 */
public class PrintCommand {
    private final Commands commands = new Commands();

    /**
     * Prints the whole text.
     *
     * @param textData the class that contains the text for the replacement
     * @author fupat002
     */
    public void print(TextData textData) {
        if (!textData.getParagraphs().isEmpty()) {
            for (int i = 0; i < textData.getParagraphs().size(); i++) {
                System.out.println((i+1) + ": " + textData.getParagraphs().get(i));
            }
            System.out.println("--------- This line marks the end. It doesn't belong to the Text! ---------");
        } else {
            System.err.println("There is no text. Add some with the commands below.");
            commands.showCommands();
        }
    }
}
