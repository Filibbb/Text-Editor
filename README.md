### TextEditor

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
| SHOW COMMANDS | Shows all available commands.|

## Starten des Editors

Starten kannst du den TextEditor entweder durch starten von `Main.java#main` in einer Entwicklungsumgebung oder du lädts dir die kompilierte .jar-Datei [hier](https://phweber.ch/ZHAW/Papp_TextEditor.jar) oder durch die Release Section [hier](https://github.com/WeberPhilippe/TextEditor/releases/tag/v1.0.0) herunter und führst sie auf deinem System (Java muss natürlich installiert sein) mit dem Befehl `java -jar Papp_TextEditor.jar` aus.
