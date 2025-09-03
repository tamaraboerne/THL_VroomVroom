# Projekt: Vroom Vroom – Autovermittlungssystem

Dieses Repository enthält den Code für **Vroom Vroom**, eine Anwendung zur **Vermietung von Fahrzeugen**. Das System besteht aus einem **Frontend** zur Benutzerinteraktion und einem **Backend**, das die Geschäftslogik und Datenverwaltung übernimmt.  

Die Backend-Services sind mit dem **Spring Framework** implementiert.

## Funktionen

### Frontend
- Anzeige verfügbarer Fahrzeuge  
- Buchung / Reservierung von Fahrzeugen  
- Benutzerregistrierung und Login  
- Verwaltung eigener Buchungen  
- Echtzeit-Updates zu Verfügbarkeit und Preisen  

### Backend
- REST-API zur Bereitstellung der Fahrzeugdaten und Buchungsfunktionen  
- Verwaltung von Nutzern, Fahrzeugen und Buchungen  
- Integration von Geschäftsregeln (z. B. Fahrzeugverfügbarkeit, Preisberechnung)  
- Persistenz über Datenbank (z. B. H2, PostgreSQL, je nach Konfiguration)  
- Sicherheit: Authentifizierung und Autorisierung  

## Technologien
- **Backend:** Java, Spring Boot, Spring Data JPA, Spring Security  
- **Frontend:** JavaScript/TypeScript (React, Angular oder Vue je nach Implementierung)  
- **Datenbank:** H2 (Entwicklung) / PostgreSQL (Produktion)  
- REST-API für die Kommunikation zwischen Frontend und Backend  


## Zielsetzung
- Bereitstellung eines Autovermittlungssystems  
- Erlernen der Integration von Frontend und Spring-Backend  

## Setup & Ausführung

### Backend
1. Projekt importieren in IDE (z. B. IntelliJ, Eclipse)  
2. Abhängigkeiten installieren (`mvn clean install` oder `gradle build`)  
3. Anwendung starten (`mvn spring-boot:run` oder `gradle bootRun`)  

### Frontend
1. Abhängigkeiten installieren (`npm install`)  
2. Anwendung starten (`npm start`)  
3. Standardmäßig läuft das Frontend auf `http://localhost:3000`  

## Kontakt
- **Projekt:** Vroom Vroom – Autovermittlung  
- **Hochschule:** TH Lübeck, Studiengang Informatik/Softwaretechnik
