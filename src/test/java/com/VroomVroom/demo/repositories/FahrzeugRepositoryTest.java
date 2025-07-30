package com.VroomVroom.demo.repositories;

import com.VroomVroom.demo.controller.MainController;
import com.VroomVroom.demo.model.Fahrzeug;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(controllers = MainController.class)
public class FahrzeugRepositoryTest {


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
    public void testFindByFahrzeugID() {
        // Erstellen Sie ein Test-Fahrzeug
        Fahrzeug testFahrzeug = new Fahrzeug("TestKategorie", "TestLeistung", "TestMarke", "TestModell",
                null, null, 5, "TestGetriebe", 100.0F, "TestTreibstoffart");

        // Speichern Sie das Test-Fahrzeug im Repository
        repoFahrzeug.save(testFahrzeug);

        // Rufen Sie das Test-Fahrzeug mithilfe der Methode findByFahrzeugID auf
        Fahrzeug foundFahrzeug = repoFahrzeug.findByFahrzeugID(testFahrzeug.getFahrzeugID());

        // Überprüfen Sie, ob das gefundene Fahrzeug nicht null ist
        assertThat(foundFahrzeug).isNotNull();

        // Überprüfen Sie, ob die ID des gefundenen Fahrzeugs der ID des Test-Fahrzeugs entspricht
        assertThat(foundFahrzeug.getFahrzeugID()).isEqualTo(testFahrzeug.getFahrzeugID());
    }


    @Test
    public void testSearchByStandort() {

        Fahrzeug testFahrzeug = new Fahrzeug("TestKategorie", "TestLeistung", "TestMarke", "TestModell",
                null, null, 5, "TestGetriebe", 100.0F, "TestTreibstoffart");

        repoFahrzeug.save(testFahrzeug);
        List<Fahrzeug> fahrzeuge = repoFahrzeug.search(testFahrzeug.getStandortAbgabe().getOrt());

        System.out.println(fahrzeuge);
        assertThat(fahrzeuge.contains(testFahrzeug));
    }


}


