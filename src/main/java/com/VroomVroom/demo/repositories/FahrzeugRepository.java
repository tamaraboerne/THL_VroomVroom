package com.VroomVroom.demo.repositories;

import java.sql.Timestamp;
import java.util.List;

import com.VroomVroom.demo.model.Standort;
import com.VroomVroom.demo.model.Fahrzeug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FahrzeugRepository extends JpaRepository<Fahrzeug, Long> {
    // Repository fuer Fahrzeuge
    @Query("SELECT f FROM Fahrzeug f WHERE f.standortAbholung.ort = :standort AND f.fahrzeugID NOT IN (SELECT b.fahrzeugID.fahrzeugID FROM Buchung b WHERE (:abholDatum >= b.abholungs_Zeitpunkt AND :abholDatum < b.rueckgabe_Zeitpunkt) OR (:rueckgabeDatum > b.abholungs_Zeitpunkt AND :rueckgabeDatum <= b.rueckgabe_Zeitpunkt))")
    List<Fahrzeug> search(@Param("standort") String standort, @Param("abholDatum") Timestamp abholDatum, @Param("rueckgabeDatum") Timestamp rueckgabeDatum);

    @Query("SELECT f FROM Fahrzeug f WHERE f.standortAbholung.ort = :standort")
    List<Fahrzeug> search(@Param("standort") String standort);

    Fahrzeug findByFahrzeugID(Long fahrzeugID);
}