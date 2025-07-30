package com.VroomVroom.demo.controller;

import com.VroomVroom.demo.model.Buchung;
import com.VroomVroom.demo.model.Fahrzeug;
import com.VroomVroom.demo.model.Standort;
import com.VroomVroom.demo.repositories.BuchungsRepository;
import com.VroomVroom.demo.repositories.FahrzeugRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.security.auth.UserPrincipal;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private FahrzeugRepository repoFahrzeug;

    @MockBean
    private BuchungsRepository repoBuchung;

    @InjectMocks
    @Autowired
    private MainController mainController;

    @Test
    public void testFahrzeugInserieren() throws Exception {
        /* Inseriert ein TestFahrzeug und prüft, ob es im repository ist*/

        Standort testStandort = new Standort();
        testStandort.setHausnummer("TestHausnummer");
        testStandort.setOrt("TestOrt");
        testStandort.setPlz(23881);
        testStandort.setStrasse("TestStrasse");

        Fahrzeug testFahrzeug = new Fahrzeug("TestKategorie", "TestLeistung", "TestMarke", "TestModell",
                null, null, 5, "TestGetriebe", 100.0F, "TestTreibstoffart");


        mainController.fahrzeugInserieren(new UserPrincipal("admin"), testFahrzeug, testStandort, testStandort);
        repoFahrzeug.save(testFahrzeug);

        List<Fahrzeug> liste = repoFahrzeug.search(testStandort.getOrt());

        System.out.println(testFahrzeug);
        System.out.println(liste);


        assertThat(liste).isNotEmpty();
        assertThat(liste.contains(testFahrzeug));


        /* mockmvc.perform(MockMvcRequestBuilders.post("/FahrzeugInserieren")
                .contentType("Fahrzeug")
                .content("TestFahrzeug")
                .accept("Fahrzeug"))
                .andExpect(status().isOk());
                //.andExpect(); */
    }

    //@Test
    public void testFahrzeugDetail() {
        //mainController.fahrzeugDetail(new UserPrincipal("admin"), );

    }

    //@Test
    public void testBuchungErstellen() {
        Fahrzeug testFahrzeug = new Fahrzeug("TestKategorie", "TestLeistung", "TestMarke", "TestModell",
                null, null, 5, "TestGetriebe", 100.0F, "TestTreibstoffart");


        Buchung buchung = new Buchung();
        buchung.setFahrzeugID(testFahrzeug);

    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
