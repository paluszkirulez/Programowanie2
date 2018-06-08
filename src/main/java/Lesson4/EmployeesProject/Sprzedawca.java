package Lesson4.EmployeesProject;

import java.util.List;

public class Sprzedawca extends PracownikWydziału {
    List<Projekt> listaOprogramowaniaSprzedanego;
    int Zarobek;

    public void sprzedaj(Projekt produkt){
        listaOprogramowaniaSprzedanego.add(produkt);
        produkt.setCzySkonczony(true);
        Zarobek = Zarobek + produkt.getCenaOprogramowania();
    }
}
