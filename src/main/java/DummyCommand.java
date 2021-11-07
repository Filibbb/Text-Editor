/**
 * A utility class that contains the dummy command as static methods. (Limitation as we are not allowed to use interfaces its easer to make the methods static)
 *
 * @author abuechi
 * @version 1.0.0
 */
public class DummyCommand {
    private static final String dummyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sed quam sit amet ex dapibus egestas vel congue metus. Donec id eleifend nisi, vitae eleifend tortor. Quisque euismod vitae nisi fringilla dignissim. In aliquam finibus nisl vel euismod. Ut ac sodales elit. Proin rhoncus libero turpis, eget tempor nisl consequat sed. Proin tempus erat magna, vitae sodales arcu fringilla sit amet. Nunc elementum, velit placerat iaculis feugiat, lectus dolor dapibus velit, in maximus sapien felis at arcu. Nulla mollis suscipit egestas. Phasellus a volutpat libero, nec tincidunt tortor. Aenean mattis ligula eu efficitur ultricies. Vestibulum ac nibh sodales, venenatis sapien vel, maximus nisi. Curabitur feugiat dictum tortor, a hendrerit urna tincidunt vitae.";

    private DummyCommand() {
    }

    /**
     * @param text the text to which the dummy text will be added. Text will be added at last position if no param will be given.
     * @return boolean value representing the success of the operation.
     */
    public static boolean executeDummyCommand(TextData text) {
        return dummyCommand(text, null);
    }

    /**
     * @param text the text where the dummy text should be added
     * @return boolean value representing the success of the operation.
     */
    public static boolean executeDummyCommand(TextData text, int offset) {
        return dummyCommand(text, offset);
    }

    private static boolean dummyCommand(TextData text, Integer offset) {
        return text.insertTextAt(offset, " " + dummyText);
    }
}
