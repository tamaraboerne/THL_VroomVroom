package com.VroomVroom.demo.repositories;

import com.VroomVroom.demo.model.Buchung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuchungsRepository extends JpaRepository<Buchung, Long> {
    // Repository fuer Buchungen
}
