package projektPrzedsiebiorstwo;

import Lesson4.EmployeesProject.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class testPrzedsiebiorstwo {
    private Przedsiębiorstwo przedsiębiorstwo;
    Kierownik testowyKierownik2;
    Kierownik testowyKierownik;
    private Wydział wydział;

    Projekt projekt;


    @Before
    public void setup(){
        przedsiębiorstwo = new Przedsiębiorstwo("Moje przedsiębiorstwo");
        long years = 10;
        LocalDate dataZatrudnienia = LocalDate.now().minusYears(10);
        testowyKierownik = new Kierownik(1500,"Karol","Sokol",dataZatrudnienia);
        testowyKierownik2 = new Kierownik(1500,"Bartek","Sokol",dataZatrudnienia);
        projekt = new Projekt("testowy projekt");
        wydział = new Wydział("testowy wydzial");

    }

    //testy metod
    @Test(expected = KierownikJestJuzZatrudnionyException.class)
    public void testZatrudnijKierownika() throws KierownikJestJuzZatrudnionyException {
        przedsiębiorstwo.zatrudnijKierownika(testowyKierownik);
        przedsiębiorstwo.zatrudnijKierownika(testowyKierownik);
    }

    @Test
    public void testZatrudnijDrugiegoKierownika() throws KierownikJestJuzZatrudnionyException {
        przedsiębiorstwo.zatrudnijKierownika(testowyKierownik);
        przedsiębiorstwo.zatrudnijKierownika(testowyKierownik2);
        Assert.assertEquals(przedsiębiorstwo.getKieronictwo().contains(testowyKierownik),true);
    }

    @Test(expected = BrakDzialuException.class)
    public void testDodajPrjektDlaKierownikaBezWydziału() throws BrakDzialuException, KierownikZajetyException {
        przedsiębiorstwo.rozpocznijNowyProjekt(testowyKierownik,projekt);
    }
    @Test
    public void testDodajPrjekt() throws BrakDzialuException, KierownikZajetyException, KierownikJestJuzZatrudnionyException, KierownikMaJużWydziałException {
        przedsiębiorstwo.zatrudnijKierownika(testowyKierownik);
        testowyKierownik.setWydziałKierownika(wydział);
        przedsiębiorstwo.rozpocznijNowyProjekt(testowyKierownik,projekt);
        Assert.assertEquals(przedsiębiorstwo.getMapaProjektow().keySet().contains(testowyKierownik),true);
    }
}
