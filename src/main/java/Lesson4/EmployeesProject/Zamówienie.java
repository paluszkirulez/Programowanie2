package Lesson4.EmployeesProject;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class Zamówienie {
    private final Set<Projekt> projekty;
    private final LocalDate dataZamowienia;

    public Zamówienie(Set<Projekt> projekty, LocalDate dataZamowienia) {
        this.projekty = sprawdzProjekty(projekty);
        this.dataZamowienia = dataZamowienia;



    }

    public void addProjekty(Set<Projekt> projekty){
        this.projekty.addAll(sprawdzProjekty(projekty));
    }

    public Set<Projekt> sprawdzProjekty(Set<Projekt> projekty){
        long numberOfMonths = 1;
        Set<Projekt> projektyDoDodania = projekty.stream().filter(x->x.getDeadline().plusMonths(numberOfMonths).isBefore(dataZamowienia)).collect(Collectors.toSet());
        if(projektyDoDodania.size() != projekty.size()){
            System.out.println("jeden z projektow kończył się zbyt pozno");
        }
        return projektyDoDodania;
    }

    public LocalDate getDataZamowienia() {
        return dataZamowienia;
    }

    public Set<Projekt> getProjekty() {
        return projekty;
    }

    public Projekt getExactProjekt(Projekt p){
        if( projekty.contains(p)){
            return p;
        }
        return null;
    }
}
