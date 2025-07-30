package com.VroomVroom.demo.controller;

import com.VroomVroom.demo.model.Standort;
import com.VroomVroom.demo.model.Buchung;
import com.VroomVroom.demo.model.Fahrzeug;

import java.security.Principal;
import java.sql.Time;
import java.sql.Timestamp;


import com.VroomVroom.demo.model.Suchformular;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.VroomVroom.demo.repositories.BuchungsRepository;
import com.VroomVroom.demo.repositories.FahrzeugRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;


@Controller
public class MainController {

    /**
     * Booking Respository
     */
    @Autowired
    private final BuchungsRepository repoBuchung;
    /**
     * Vehicle Respository
     */
    @Autowired
    private final FahrzeugRepository repoFahrzeug;

    @Autowired
    public MainController (BuchungsRepository repoBuchung, FahrzeugRepository repoFahrzeug){
        this.repoBuchung = repoBuchung;
        this.repoFahrzeug = repoFahrzeug;
    }

    // Nur zum testen das sich die Seite öffnet
    @GetMapping("/fahrzeug_inserieren")
    public String showFahrzeugInserieren(final Model model, Principal principal) {

        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }

        Fahrzeug vehicle = new Fahrzeug();

        model.addAttribute("fahrzeugSave", vehicle);
        model.addAttribute("rueckgabeStandortSave", new Standort());
        model.addAttribute("abholungStandortSave", new Standort());

        return "fahrzeug_inserieren";
    }

    @PostMapping("/fahrzeug_inserieren")
    public String fahrzeugInserieren(Principal principal,
                                     @ModelAttribute("fahrzeugSave") Fahrzeug newfahrzeug,
                                     @ModelAttribute("abholungStandortSave") Standort abholdStandort,
                                     @ModelAttribute("rueckgabeStandortSave") Standort rueckgabeStandort) {
        newfahrzeug.setStandortAbholung(abholdStandort);
        newfahrzeug.setStandortAbgabe(rueckgabeStandort);
        repoFahrzeug.save(newfahrzeug);

        return "fahrzeug_inserieren";
    }

    // Nur zum testen das sich die Seite öffnet
    @GetMapping("/fahrzeugDetail")
    public String fahrzeugDetail(Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        return "fahrzeugDetail";
    }

    @GetMapping("/fahrzeug_buchen")
    public String fahrzeug_buchen() {
        return "fahrzeug_buchen";
    }

    @GetMapping("/datenschutz")
    public String datenschutzt() { return "datenschutz"; }

    @GetMapping("/impressum")
    public String impressum() { return "impressum"; }


    @GetMapping("/login")
    public ModelAndView viewHomePage() {
        ModelAndView login = new ModelAndView("login");
        login.addObject("admin", true);
        login.addObject("active", true);
        return login;
    }
/*
    @PostMapping(path = "/fahrzeug_inserieren")
    public String fahrzeugInserieren(final Fahrzeug fahrzeug) {
        repoFahrzeug.save(fahrzeug);
        return "Startseite";
    }

 */

    @PostMapping(path = "/fahrzeug_buchen")
    public String buchungErstellen(final Buchung buchung) {
        repoBuchung.save(buchung);
        return "Startseite";
    }


    @GetMapping("FahrzeugeSuchens")
    public String fahrzeugeSuchen(
            @RequestParam("standort") String standort,
            @RequestParam("abholDatum") Timestamp abholDatum,
            @RequestParam("rueckgabeDatum") Timestamp rueckgabeDatum) {
        final List<Fahrzeug> vehicles = repoFahrzeug.search(standort, abholDatum, rueckgabeDatum);
        ModelAndView sucheModel = new ModelAndView("suche");
        sucheModel.addObject("Fahrzeuge", vehicles);
        return "Startseite";
    }

    @GetMapping("FahrzeugeSuchen")
    public String fahrzeugeSuchen(
            @RequestParam("standort") String standort,
            @ModelAttribute("suchformular") String suchformular) {
        final List<Fahrzeug> vehicles = repoFahrzeug.search(standort);
        ModelAndView sucheModel = new ModelAndView("suche");
        sucheModel.addObject("Fahrzeuge", vehicles);
        return "Startseite";
    }
    /* Beans
    @ModelAttribute("fahrzeugSaves")
    public Fahrzeug fahrzeug() {
        return new Fahrzeug();
    }

     */

    @ModelAttribute("suchformular") //Beans
    public Suchformular suchformular() {
        return new Suchformular();
    }
    /*
    @GetMapping("/Startseite")
    public String allVehicles(final Model model,
                              @RequestParam(value = "standort", required = false) String standort,
                              @RequestParam(value = "abholDatum", required = false) LocalDate abholDatum) {
        System.out.println(standort);
        System.out.println(abholDatum);
        final List<Fahrzeug> vehicles = repoFahrzeug.search(standort);
        model.addAttribute("Fahrzeuge", vehicles);
        return "Startseite";
    }

     */

    @GetMapping("/Startseite")
    public String allVehicles(final Model model, Principal principal,
                              @RequestParam(value = "standort", required = false) String standort,
                              @RequestParam(value = "abholDatum", required = false) LocalDate abholDatum,
                              @RequestParam(value = "rueckgabeDatum", required = false) LocalDate reuckgabeDatum) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }

        final List<Fahrzeug> vehicles;
        if (standort == null && abholDatum == null && reuckgabeDatum == null) {
            vehicles = repoFahrzeug.findAll();
        } else if (abholDatum == null && reuckgabeDatum == null) {
            vehicles = repoFahrzeug.search(standort);
        } else {
            Timestamp abholdatum = abholDatum != null ? Timestamp.valueOf(abholDatum.atStartOfDay()) : null;
            Timestamp rueckgabedatum = reuckgabeDatum != null ? Timestamp.valueOf(reuckgabeDatum.atStartOfDay()) : null;
            vehicles = repoFahrzeug.search(standort, abholdatum, rueckgabedatum);
        }
        model.addAttribute("Fahrzeuge", vehicles);
        return "Startseite";
    }




    @GetMapping("/FahrzeugAnzeigen")
    public String fahrzeugDetailsAnzeigen(
            @RequestParam("fahrzeug") Fahrzeug fahrzeug) {
        ModelAndView detailsModel = new ModelAndView("details");
        detailsModel.addObject("Fahrzeug", fahrzeug);
        return "fahrzeugDetail";
    }

}
