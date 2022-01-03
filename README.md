ACHTUNG! Details unten beachten, ansonsten ist ein starten der Datenbank nicht möglich, da anstatt einer H2 Datenbank eine PostGres verwendet wurde!

Zum Starten der Anwendung muss entweder eine lokale Postgres Datenbank erstellt werden, mit den Angaben:
url: jdbc:postgresql://localhost:5432/testdb2
username: postgres
Das Passwort für die Datenbank ist das für die lokale Postgres Installation gewählte.

ODER!

Die application.properties Datei muss an eine lokale Postgres Datenbank angepasst werden.
spring.datasource.url=jdbc:postgresql://Host:Port/Datenbankname
Benutzername und Passwort an die lokale Datenbank anpassen.
Defaultbenutzer von Postgres Datenbanken ist:
postgres


Sollte dieser Schritt übersprungen werden so wird das Programm beim Starten ein Fehler werfen!

Beim ersten starten der Anwendung, muss die Datenbank die "Sql.sql" Skriptdatei ausgeführt werden.
Dies kann entweder geschen über IntelliJ mit dem Datenbank Plug-In welches am rechten Bildschirmrand unter dem Mavensymbol ist.
Für eine Verbindung von IntelliJ mit einer PostGres Datenbank sind folgende Schritte notwendig:
1. Auf das "Datenbank" Tab rechts klicken.
2. Auf das Plus -> Datenquelle -> Postgrsql.
3. Die Daten der Verbindung eingeben und Verbindung testen. Sollte der Test negativ sein, auf tippfehler überprüfen.
4.Ist es erfolgreich so geht man in die Datenbank -> schemas -> Tabellen und macht einen rechtsklick auf "SQL Skript ausführen".
   Dann muss das mitgelieferte SQL Skript ausgewählt werden.
   
Oder dies kann ausgeführt mit einem Drittprogramm wie z.B. DBeaver. 


Anschließend kann das Programm gestartet werden.

Link zur Anfangsseite:
localhost:8080/


