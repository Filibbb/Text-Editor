package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Contains the junit tests for the IndexCommand method.
 *
 * @author kuengpas
 * @version 1.0.0
 */
public class IndexCommandTest {

    /**
     * Executes a test if the resulting terms have the right indices assigned to it.
     *
     * @author kuengpas
     */
    @Test
    public void testIfAssignmentsAreCorrect() {
        TextData text = new TextData();
        String paragraph1 = "Wenn man das Wetter 30 Jahre lang beobachtet, die wichtigsten Daten aufschreibt und Mittelwerte daraus macht, "
                + "dann hat man ziemlich gut das Klima einer Region oder eben der Erde beschrieben. Das ist etwas anderes als das aktuelle "
                + "Wetter an einem bestimmten Ort.";
        String paragraph2 = "Deshalb ist es auch einfacher, das Klima in 20 Jahren zu beschreiben als das Wetter in 20 Tagen vorherzusagen. "
                + "Wie das naemlich an einem genauen Ort und zu einem bestimmten Zeitpunkt aussehen wird, ist unmoeglich zu berechnen.";
        String paragraph3 = "Andere Regionen dieser Welt sind viel staerker betroffen als wir. Die Eiskappen in der Arktis und auf den Gebirgen "
                + "schmelzen bereits. Auch die Ozeane leiden.";
        String paragraph4 = "Ohne Treibhausgase (aber bei ansonsten gleichbleibenden Bedingungen) waere es auf der Erdoberflaeche im Mittel etwa "
                + "minus 18 Grad Celsius kalt. Durch den Treibhauseffekt wird die Erde also ueberhaupt erst bewohnbar, die Temperatur steigt um "
                + "circa 32 Grad Celsius auf rund plus 14 Grad Celsius.";
        String paragraph5 = "Die Luft an der Erdoberflaeche hat sich gegenueber der vorindustriellen Zeit im globalen Mittel bereits um mehr als "
                + "ein Grad Celsius erwaermt. Ein solches Temperaturniveau gab es laut den verfuegbaren palaeoklimatischen Daten noch nie waehrend "
                + "der vergangenen 2.000 Jahre.";
        text.insertTextAt(1, paragraph1);
        text.insertTextAt(2, paragraph2);
        text.insertTextAt(3, paragraph3);
        text.insertTextAt(4, paragraph4);
        text.insertTextAt(5, paragraph5);

        String actualOutput = IndexCommand.executeIndexCommand(text);

        assertEquals(
                "Celsius     \t\t[4, 5]\n" +
                        "Grad     \t\t[4, 5]\n", actualOutput
        );
    }

    /**
     * Executes a test if the numbers and Punctuation is removed from the text (one edge case)
     *
     * @author kuengpas
     */
    @Test
    public void testIfNumbersAndPunctuationIsRemovedFromText() {
        TextData text = new TextData();
        String paragraph1 = "Error Error Error Error. No keyboard. Press F1 to continue";
        text.insertTextAt(1, paragraph1);

        String actualOutput = IndexCommand.executeIndexCommand(text);

        assertEquals(
                "Error     \t\t[1]\n", actualOutput
        );
    }

    @Test
    public void testIfEmptyStringsCanBeHandled() {
        TextData text = new TextData();

        String actualOutput = IndexCommand.executeIndexCommand(text);

        assertEquals(
                "", actualOutput
        );
    }

}