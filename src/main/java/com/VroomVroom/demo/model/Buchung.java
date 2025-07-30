package com.VroomVroom.demo.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "BUCHUNGEN")
public class Buchung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long buchungsID;

    @Column(name = "ABHOLUNGS_DATUM")
    private Timestamp abholungs_Zeitpunkt;

    @Column(name = "RUECKGABE_DATUM")
    private Timestamp rueckgabe_Zeitpunkt;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private BuchungEnum buchungs_Status;

    @ManyToOne
    @JoinColumn(name = "FAHRZEUG_ID")
    private Fahrzeug fahrzeugID;

    @OneToOne
    @JoinColumn(name = "BENUTZER_ID")
    private Benutzer benutzer;

    @OneToOne
    @JoinColumn(name = "BEZAHLUNGS_ID")
    private Bezahlung bezahlung;

    public long getBuchungsID() {
        return buchungsID;
    }

    public void setFahrzeugID(Fahrzeug fahrzeugID) {
        this.fahrzeugID = fahrzeugID;
    }

    public Fahrzeug getFahrzeugID() {
        return fahrzeugID;
    }

    public void setAbholungsZeitpunkt(Timestamp abholungs_Zeitpunkt) {
        this.abholungs_Zeitpunkt = abholungs_Zeitpunkt;
    }

    public Timestamp getAbholungsZeitpunkt() {
        return abholungs_Zeitpunkt;
    }

    public void setRueckgabeZeitpunkt(Timestamp rueckgabe_Zeitpunkt) {
        this.rueckgabe_Zeitpunkt = rueckgabe_Zeitpunkt;
    }

    public Timestamp getRueckgabeZeitpunkt() {
        return rueckgabe_Zeitpunkt;
    }

    public void setBuchungsStatus(BuchungEnum buchungs_Status) {
        this.buchungs_Status = buchungs_Status;
    }

    public BuchungEnum getBuchungsStatus() {
        return buchungs_Status;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBezahlung(Bezahlung bezahlung) {
        this.bezahlung = bezahlung;
    }

    public Bezahlung getBezahlung() {
        return bezahlung;
    }
}
