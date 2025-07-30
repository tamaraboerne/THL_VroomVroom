package com.VroomVroom.demo.model;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "BEZHALUNGEN")
public class Bezahlung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long bezahlungsID;

    @Column(name = "KARTENNUMMER")
    private long kartennummer;

    @Column(name = "KARTENINHABER")
    private String karteninhaber;

    @Column(name = "ABLAUFDATUM")
    private Timestamp ablaufdatum;

    @Column(name = "PRUEFSUMME")
    private int pruefsumme;

    @OneToOne(mappedBy = "bezahlung")
    private Buchung buchung;

    public long getBezahlungsID() {
        return bezahlungsID;
    }

    public long getKartennummer() {
        return kartennummer;
    }

    public void setKartennummer(long kartennummer) {
        this.kartennummer = kartennummer;
    }

    public String getKarteninhaber() {
        return karteninhaber;
    }

    public void setKarteninhaber(String karteninhaber) {
        this.karteninhaber = karteninhaber;
    }

    public Timestamp getAblaufdatum() {
        return ablaufdatum;
    }

    public void setAblaufdatum(Timestamp ablaufdatum) {
        this.ablaufdatum = ablaufdatum;
    }

    public int getPruefsumme() {
        return pruefsumme;
    }

    public void setPruefsumme(int pruefsumme) {
        this.pruefsumme = pruefsumme;
    }
}
