package com.VroomVroom.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "STANDORTE")
public class Standort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long standortID;

    @Column(name = "STRASSE")
    private String strasse;

    @Column(name = "ORT")
    private String ort;

    @Column(name = "HAUSNUMMER")
    private String hausnummer;

    @Column(name = "PLZ")
    private int plz;

    public long getStanortID() {
        return standortID;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    @Override
    public String toString() {
        return String.format("Standort: [%s %s; %d %s]", strasse, hausnummer, plz, ort);
    }
}
