package ch.zhaw.papp;

/**
 * This is the main class. It starts the Text Editor.
 * It does not expect any arguments.
 *
 * @author kuengpas
 * @version 1.0.0
 */

public class Main {
    /**
     * Starts the main application.
     *
     * @param args no use for this tool
     * @author kuengpas
     */
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.startEditing();
    }
}