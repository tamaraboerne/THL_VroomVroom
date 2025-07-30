package com.VroomVroom.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "FAHRZEUGE")
public class Fahrzeug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long fahrzeugID;

    @Column(name = "KATEGORIE")
    public String kategorie;

    @Column(name = "LEISTUNG")
    public String leistung;

    @Column(name = "MARKE")
    public String marke;

    @Column(name = "MODELL")
    public String modell;

    @ManyToOne
    @JoinColumn(name = "ABGABE_STANDORT")
    public Standort standortAbgabe;

    @ManyToOne
    @JoinColumn(name = "ABHOLUNGS_STANDORT")
    public Standort standortAbholung;

    @Column(name = "SITZE")
    public Integer sitze;

    @Column(name = "GETRIEBEART")
    public String getriebeart;

    @Column(name = "TAGESPREIS")
    public Float tagespreis;

    @Column(name = "TREIBSTOFFART")
    public String treibstoffart;

    // Konstruktor mit Parametern
    public Fahrzeug(String kategorie, String leistung, String marke, String modell,
                    Standort standortAbgabe, Standort standortAbholung, Integer sitze,
                    String getriebeart, Float tagespreis, String treibstoffart) {
        this.kategorie = kategorie;
        this.leistung = leistung;
        this.marke = marke;
        this.modell = modell;
        this.standortAbgabe = standortAbgabe;
        this.standortAbholung = standortAbholung;
        this.sitze = sitze;
        this.getriebeart = getriebeart;
        this.tagespreis = tagespreis;
        this.treibstoffart = treibstoffart;
    }

    public Fahrzeug() {

    }

    public Long getFahrzeugID() {
        return fahrzeugID;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getLeistung() {
        return leistung;
    }

    public void setLeistung(String leistung) {
        this.leistung = leistung;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public Standort getStandortAbgabe() {
        return standortAbgabe;
    }

    public void setStandortAbgabe(Standort standortAbgabe) {
        this.standortAbgabe = standortAbgabe;
    }

    public Standort getStandortAbholung() {
        return standortAbholung;
    }

    public void setStandortAbholung(Standort standortAbholung) {
        this.standortAbholung = standortAbholung;
    }

    public Integer getSitze() {
        return sitze;
    }

    public void setSitze(Integer sitze) {
        this.sitze = sitze;
    }

    public String getGetriebeart() {
        return getriebeart;
    }

    public void setGetriebeart(String getriebeart) {
        this.getriebeart = getriebeart;
    }

    public Float getTagespreis() {
        return tagespreis;
    }

    public void setTagespreis(Float tagespreis) {
        this.tagespreis = tagespreis;
    }

    public String getTreibstoffart() {
        return treibstoffart;
    }

    public void setTreibstoffart(String treibstoffart) {
        this.treibstoffart = treibstoffart;
    }

    public String toString() {
        return String.format("%d | %s | %s | %s | %s | %d | %s | %f | %s", fahrzeugID, kategorie, leistung, marke, modell, sitze, getriebeart, tagespreis, treibstoffart);
    }

    public boolean equals(Fahrzeug fahrzeug) {
        return this.fahrzeugID == fahrzeug.fahrzeugID;
    }
}

