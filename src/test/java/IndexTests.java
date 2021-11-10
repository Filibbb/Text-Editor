import static org.junit.jupiter.api.Assertions.assertEquals;
import ch.zhaw.papp.TextData;
import ch.zhaw.papp.commands.IndexCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Contains the junit tests for the index method.
 *
 * @author kuengpas
 * @version 1.0.0
 */
public class IndexTests {

    private final static TextData text = new TextData();

    /**
     * Divides text into paragraphs and gives them respective numbers. Method must be executed before all subsequent
     * tests in the current test class.
     * @author kuengpas
     */
    @BeforeAll
    public static void setUp() {
        String paragraph1 = "Wenn man das Wetter 30 Jahre lang beobachtet, die wichtigsten Daten aufschreibt und Mittelwerte daraus macht, "
                + "dann hat man ziemlich gut das Klima einer Region oder eben der Erde beschrieben. Das ist etwas anderes als das aktuelle "
                + "Wetter an einem bestimmten Ort.";
        String paragraph2 = "Deshalb ist es auch einfacher, das Klima in 20 Jahren zu beschreiben als das Wetter in 20 Tagen vorherzusagen. "
                + "Wie das nämlich an einem genauen Ort und zu einem bestimmten Zeitpunkt aussehen wird, ist unmöglich zu berechnen.";
        String paragraph3 = "Andere Regionen dieser Welt sind viel stärker betroffen als wir. Die Eiskappen in der Arktis und auf den Gebirgen "
                + "schmelzen bereits. Auch die Ozeane leiden.";
        String paragraph4 = "Ohne Treibhausgase (aber bei ansonsten gleichbleibenden Bedingungen) wäre es auf der Erdoberfläche im Mittel etwa "
                + "minus 18 Grad Celsius kalt. Durch den Treibhauseffekt wird die Erde also überhaupt erst bewohnbar, die Temperatur steigt um "
                + "circa 32 Grad Celsius auf rund plus 14 Grad Celsius.";
        String paragraph5 = "Die Luft an der Erdoberfläche hat sich gegenüber der vorindustriellen Zeit im globalen Mittel bereits um mehr als "
                + "ein Grad Celsius erwärmt. Ein solches Temperaturniveau gab es laut den verfügbaren paläoklimatischen Daten noch nie während "
                + "der vergangenen 2.000 Jahre.";
        text.insertTextAt(1,paragraph1);
        text.insertTextAt(2,paragraph2);
        text.insertTextAt(3,paragraph3);
        text.insertTextAt(4,paragraph4);
        text.insertTextAt(5,paragraph5);
    }
    /**
     * Executes a test if all words in capital letters within a given text are recognized the right way.
     * @author kuengpas
     */
    @Test
    public void testCorrectTextTransformation() {
        ArrayList<String> allTerms = IndexCommand.getAllTerms(text.getParagraphs());
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Wenn");
        expectedList.add("Wetter");
        expectedList.add("Jahre");
        expectedList.add("Daten");
        expectedList.add("Mittelwerte");
        expectedList.add("Klima");
        expectedList.add("Region");
        expectedList.add("Erde");
        expectedList.add("Das");
        expectedList.add("Wetter");
        expectedList.add("Ort");
        expectedList.add("Deshalb");
        expectedList.add("Klima");
        expectedList.add("Jahren");
        expectedList.add("Wetter");
        expectedList.add("Tagen");
        expectedList.add("Wie");
        expectedList.add("Ort");
        expectedList.add("Zeitpunkt");
        expectedList.add("Andere");
        expectedList.add("Regionen");
        expectedList.add("Welt");
        expectedList.add("Die");
        expectedList.add("Eiskappen");
        expectedList.add("Arktis");
        expectedList.add("Gebirgen");
        expectedList.add("Auch");
        expectedList.add("Ozeane");
        expectedList.add("Ohne");
        expectedList.add("Treibhausgase");
        expectedList.add("Bedingungen");
        expectedList.add("Erdoberfläche");
        expectedList.add("Mittel");
        expectedList.add("Grad");
        expectedList.add("Celsius");
        expectedList.add("Durch");
        expectedList.add("Treibhauseffekt");
        expectedList.add("Erde");
        expectedList.add("Temperatur");
        expectedList.add("Grad");
        expectedList.add("Celsius");
        expectedList.add("Grad");
        expectedList.add("Celsius");
        expectedList.add("Die");
        expectedList.add("Luft");
        expectedList.add("Erdoberfläche");
        expectedList.add("Zeit");
        expectedList.add("Mittel");
        expectedList.add("Grad");
        expectedList.add("Celsius");
        expectedList.add("Ein");
        expectedList.add("Temperaturniveau");
        expectedList.add("Daten");
        expectedList.add("Jahre");


        assertEquals(expectedList, allTerms);
    }

    /**
     * Executes a test if terms with a minimal occurrence are recognized.
     * @author kuengpas
     */
    @Test
    void testIfAllTermsWithOccurenceMinFourAreInList() {
        List<String> termsWithOccurrenceMinFour = IndexCommand.getTermsWithMoreThanThreeOccurrences(text);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Celsius");
        expectedList.add("Grad");

        assertEquals(expectedList, termsWithOccurrenceMinFour);

    }
    /**
     * Executes a test if the resulting terms have the right indices assigned to it.
     * @author kuengpas
     */
    @Test
    void testIfAssignmentsAreCorrect() {
        ArrayList<String> arrayList = IndexCommand.getTermsWithMoreThanThreeOccurrences(text);
        HashMap<String, ArrayList<Integer>> expectedMap = new HashMap<>();
        HashMap<String, ArrayList<Integer>> map = IndexCommand.allocateIndices(text, arrayList);
        ArrayList<Integer> parasWithCelsius = new ArrayList<>();
        parasWithCelsius.add(4);
        parasWithCelsius.add(5);

        ArrayList<Integer> parasWithGrad = new ArrayList<>();
        parasWithGrad.add(4);
        parasWithGrad.add(5);

        expectedMap.put("Celsius", parasWithCelsius);
        expectedMap.put("Grad", parasWithGrad);

        assertEquals (expectedMap, map);
    }
}