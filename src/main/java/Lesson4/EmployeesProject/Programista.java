package Lesson4.EmployeesProject;

import java.util.Optional;

public class Programista extends PracownikWydziału {
    private String jezykProgramowania;
    private Optional<Projekt> nazwaProjektu;

    public Optional<Projekt> getNazwaProjektu() {
        return nazwaProjektu;
    }

    public void setNazwaProjektu(Optional<Projekt> nazwaProjektu) {
        this.nazwaProjektu = nazwaProjektu;
    }
}
