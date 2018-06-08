package projektPrzedsiebiorstwo;

import Lesson2.Options.BrakElementuException;
import Lesson4.EmployeesProject.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testWydzial {
    private Wydział wydział;

    @Before
    public void setup(){
        wydział = new Wydział("testowy wydzial");
    }

    @Test
    public void testDodawaniePracownika() throws PracownikJuzZatrudnionyException {
        PracownikWydziału sprzedawca = new Sprzedawca();
        sprzedawca.setStanowisko(Stanowisko.SPRZEDAWCA);
        wydział.zatrudnij(sprzedawca);
        Assert.assertEquals(wydział.getListaPracownikowWydziału().contains(sprzedawca),true);
    }
    @Test(expected = SprzedawcaZatrudnionyException.class)
    public void testDodawanieSrzedawcyDwaRazy() throws PracownikJuzZatrudnionyException {
        PracownikWydziału sprzedawca = new Sprzedawca();
        PracownikWydziału sprzedawca2 = new Sprzedawca();
        sprzedawca.setStanowisko(Stanowisko.SPRZEDAWCA);
        sprzedawca2.setStanowisko(Stanowisko.SPRZEDAWCA);
        wydział.zatrudnij(sprzedawca);
        wydział.zatrudnij(sprzedawca2);
        Assert.assertEquals(wydział.getListaPracownikowWydziału().contains(sprzedawca2),true);
    }

    @Test
    public void testDodawanieProgramistówdwarazy() throws PracownikJuzZatrudnionyException {
        PracownikWydziału programista = new Programista();
        PracownikWydziału programista2 = new Programista();
        programista.setStanowisko(Stanowisko.PROGRAMISTA);
        programista2.setStanowisko(Stanowisko.PROGRAMISTA);
        wydział.zatrudnij(programista);
        wydział.zatrudnij(programista2);
        Assert.assertEquals(wydział.getListaPracownikowWydziału().contains(programista2),true);
    }
    @Test
    public void testUsunieciePracownika() throws BrakPracownikaException, PracownikJuzZatrudnionyException {
        PracownikWydziału programista = new Programista();
        PracownikWydziału programista2 = new Programista();
        programista.setStanowisko(Stanowisko.PROGRAMISTA);
        programista2.setStanowisko(Stanowisko.PROGRAMISTA);
        wydział.zatrudnij(programista);
        wydział.zatrudnij(programista2);
        wydział.zwolnij(programista);
        Assert.assertEquals(wydział.getListaPracownikowWydziału().contains(programista),false);
    }
    @Test(expected = BrakPracownikaException.class)
    public void testUsuniecieNieistniejacegoPracownika() throws BrakPracownikaException {
        PracownikWydziału programista = new Programista();
        PracownikWydziału programista2 = new Programista();
        programista.setStanowisko(Stanowisko.PROGRAMISTA);
        programista2.setStanowisko(Stanowisko.PROGRAMISTA);
        wydział.zwolnij(programista2);
        Assert.assertEquals(wydział.getListaPracownikowWydziału().contains(programista2),false);
    }
    @Test
    public void testPrzyznajPremiePracownikom() throws PracownikJuzZatrudnionyException {
        PracownikWydziału programista = new Programista();
        PracownikWydziału programista2 = new Programista();
        programista.setStanowisko(Stanowisko.PROGRAMISTA);
        programista2.setStanowisko(Stanowisko.PROGRAMISTA);
        wydział.zatrudnij(programista);
        wydział.zatrudnij(programista2);
        wydział.przyznajPremie(500);
        wydział.przyznajPremie(1000);
        Assert.assertEquals(programista2.getPremieSum(),1500);
    }
}
