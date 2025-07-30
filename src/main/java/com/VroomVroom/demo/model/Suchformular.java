package com.VroomVroom.demo.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Suchformular {
    private String standort;
    private LocalDate abholDatum;
    private LocalDate rueckgabeDatum;

    public Suchformular() {

    }

    public LocalDate getAbholDatum() {
        return abholDatum;
    }

    public void setAbholDatum(LocalDate abholDatum) {
        this.abholDatum = abholDatum;
    }

    public LocalDate getRueckgabeDatum() {
        return rueckgabeDatum;
    }

    public void setRueckgabeDatum(LocalDate rueckgabeDatum) {
        this.rueckgabeDatum = rueckgabeDatum;
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }
}
