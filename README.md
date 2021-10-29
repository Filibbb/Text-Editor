# gruppec-papp-projekt2-text-editor

## Beschreibung

Java basiertes Einsteiger Projekt mit einem Texteditor. 

## Befehle

Die Befehle können in der Eingabeaufforderung eingegeben werden und führen dann das folgende aus.

|     Befehl    | Ausführung |
| ------------- | ------------- |
| ADD [n]       | Ruft zur Eingabe eines Absatzes auf und fügt den eingegebenen Absatz hinzu. <br> Wird keine Absatznummer n angegeben, wird der Absatz am Ende angefügt. |
| DEL [n]       | Löscht einen Absatz. Wird keine Absatznummer n angegeben, wird der letzte Absatz gelöscht.   |
| DUMMY [n]     | Fügt einen fest einprogrammierten Blindtext ein. <br> Wird keine Absatznummer n angegeben, wird der Absatz am Ende angefügt. |
| EXIT          | Beendet das Programm. |
| FORMAT RAW    | Setzt das Ausgabeformat auf die Ausgabe der Absätze mit vorangestellter Absatznummern.|
| FORMAT FIX [b]| Setzt das Ausgabeformat auf eine Ausgabe mit einer maximalen Spaltenbreite von b Zeichen ein.|
| INDEX         | Gibt einen Index (Wortverzeichnis) aller Begriffe aus, die über alle Absätze <br> gesehen öfter als dreimal vorkommen.|
| PRINT         | Ausgabe des Textes gemäss dem aktuell eingestellten Ausgabeformat.|
| REPLACE [n]   | Ruft zuerst zur Eingabe eines zu suchenden Wortes oder Textteils im Absatz n auf und <br> anschliessend zur Eingabe des Textes, mit dem das Gesuchte ersetzt werden soll. <br> Wird keine Absatznummer n angegeben, wird der letzte Absatz geändert.|


### Gruppen Mitglieder und Verantwortungsbereich

* Adrian Büchi - ...
* Philippe Weber - ...
* Patric Fuchs - ...
* Pascal Küng - ...


### Teamrules

* Wir versuchen den Code in Englisch zu schreiben d.h. zum Beispiel `ConsoleInputReader.java` oder `AddParagraph(String text, int paragraphNumber)` anstelle von deutschen Namen.
* Wir arbeiten grundsätzlich mit Branches. Branches werden auf Englisch benammst und sollten beschreiben, was in diesem Branch gemacht wird. 
* Wenn eine Änderung komplett ist, sollte diese im Idealfall in Review bei allen gestellt werden bevor auf den `Master Branch` gepushed wird. (4 Augen Prinzip)
* Git Commits bitte auf Englisch und nur Zustände comitten, die mindestens kompilieren.

Wenn wir feststellen, dass etwas nicht funktioniert bitte frühzeitig melden, wenn die oben genannten Teamrules nur hinderlich sind dies ansprechen, dann werden die Neu definiert.
