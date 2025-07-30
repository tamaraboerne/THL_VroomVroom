package com.VroomVroom.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "VROOM_BENUTZER")
public class Benutzer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long userID;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "VORNAME")
    private String vorname;

    @Column(name = "NACHNAME")
    private String nachname;

    @Column(name = "TELEFON_NMR")
    private long tel;

    @OneToOne(mappedBy = "benutzer")
    private Buchung buchung;

    public long getUserID() {
        return userID;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }
}
