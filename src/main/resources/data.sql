-- SQL Injection of dummy data

-- Standorte
INSERT INTO STANDORTE (STRASSE, ORT, HAUSNUMMER, PLZ)
VALUES
    ('Musterstrasse', 'Musterort', '10a', 24553),
    ('Mustermusterstrasse', 'Musterörtchen', '12', 24366),
    ('Muensterstrasse', 'Muenster', '9', 22411);


-- Fahrzeuge
INSERT INTO FAHRZEUGE (
    KATEGORIE,
    LEISTUNG,
    MARKE,
    MODELL,
    ABGABE_STANDORT,
    ABHOLUNGS_STANDORT,
    SITZE,
    GETRIEBEART,
    TAGESPREIS,
    TREIBSTOFFART
)
VALUES
    ('Sportwagen', '300PS', 'Audi', 'A6', 1, 2, 5, 'Automatik', 270.0, 'Diesel'),
    ('SUV', '200PS', 'Mercedes', 'GLE', 2, 3, 7, 'Automatic', 350.0, 'Benzin'),
    ('SUV', '200PS', 'Mercedes', 'GLE', 2, 3, 7, 'Automatic', 350.0, 'Benzin'),
    ('SUV', '200PS', 'Mercedes', 'GLE', 2, 3, 7, 'Automatic', 350.0, 'Benzin'),
    ('SUV', '200PS', 'Mercedes', 'GLE', 2, 3, 7, 'Automatic', 350.0, 'Benzin'),
    ('SUV', '200PS', 'Mercedes', 'GLE', 2, 3, 7, 'Automatic', 350.0, 'Benzin'),
    ('Kleinwagen', '100PS', 'Volkswagen', 'Polo', 3, 3, 5, 'Manual', 200.0, 'Benzin');


-- Bezahlungen
INSERT INTO BEZHALUNGEN (KARTENNUMMER, KARTENINHABER, ABLAUFDATUM, PRUEFSUMME)
VALUES
    (0203454892, 'Max Mustermann', CURRENT_TIMESTAMP(), 42),
    (0205454892, 'Maxima Musterfrau', CURRENT_TIMESTAMP(), 42);


-- Benutzer
INSERT INTO VROOM_BENUTZER (EMAIL, VORNAME, NACHNAME, TELEFON_NMR)
VALUES
    ('Max.Mustermann@gmail.com', 'Max', 'Mustermann', 03442275491),
    ('Maxima.Musterfrau@gmail.com', 'Maxima', 'Musterfrau', 04855983759);


-- Buchungen
INSERT INTO BUCHUNGEN (
    ABHOLUNGS_DATUM,
    RUECKGABE_DATUM,
    STATUS,
    FAHRZEUG_ID,
    BENUTZER_ID,
    BEZAHLUNGS_ID
)
VALUES
    (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ZAHLUNG_ERFOLGT', 2, 1, 1),
    (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ZAHLUNG_OFFEN', 3, 2, 2);
