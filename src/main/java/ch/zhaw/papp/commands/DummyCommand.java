package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

/**
 * Command class that contains the dummy command as static methods. (Limitation as we are not allowed to use interfaces, it's easier to make the methods static)
 *
 * @author abuechi
 * @version 1.0.0
 */
public class DummyCommand {
    private static final String dummyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sed quam sit amet ex dapibus egestas vel congue metus. Donec id eleifend nisi, vitae eleifend tortor. Quisque euismod vitae nisi fringilla dignissim. In aliquam finibus nisl vel euismod. Ut ac sodales elit. Proin rhoncus libero turpis, eget tempor nisl consequat sed. Proin tempus erat magna, vitae sodales arcu fringilla sit amet. Nunc elementum, velit placerat iaculis feugiat, lectus dolor dapibus velit, in maximus sapien felis at arcu. Nulla mollis suscipit egestas. Phasellus a volutpat libero, nec tincidunt tortor. Aenean mattis ligula eu efficitur ultricies. Vestibulum ac nibh sodales, venenatis sapien vel, maximus nisi. Curabitur feugiat dictum tortor, a hendrerit urna tincidunt vitae.";
    private final Command command;

    /**
     * Creates an instance of the dummy command with its related command information.
     *
     * @param command the information on how the command should be executed
     * @author abuechi
     */
    public DummyCommand(Command command) {
        this.command = command;
    }

    /**
     * Adds a dummy text in the given paragraph or at the end
     *
     * @param textData the current TextData object
     * @author abuechi
     */
    public void execute(TextData textData) {
        if (command != null) {
            dummyCommand(textData, command.getNumericParams());
        } else {
            System.err.println("Command is missing the command information.");
        }
    }

    private void dummyCommand(TextData text, Integer offset) {
        final boolean successFull = text.insertTextAt(offset, dummyText);
        if (!successFull) {
            System.err.println("Dummy command was not successful");
        }
    }
}
