package com.VroomVroom.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ADMIN")
public class Admin {

    @Id
    @Column(name = "benutzername")
    private String benutzername;

    @Column(name = "passwort")
    private String passwort;

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
}
