package com.VroomVroom.demo.model;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum BuchungEnum {

    @Enumerated(EnumType.STRING)
    ZAHLUNG_OFFEN,

    @Enumerated(EnumType.STRING)
    ZAHLUNG_NICHT_ERFOLGREICH,

    @Enumerated(EnumType.STRING)
    ZAHLUNG_ERFOLGT,

    @Enumerated(EnumType.STRING)
    FAHRZEUG_ABGEHOLT,

    @Enumerated(EnumType.STRING)
    FAHRZEUG_ABGEGEBEN,

    @Enumerated(EnumType.STRING)
    FAHRZEUG_BESCHAEDIGT;
}
