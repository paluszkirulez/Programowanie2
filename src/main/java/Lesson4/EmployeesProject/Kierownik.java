package Lesson4.EmployeesProject;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Kierownik extends Pracownik {

    public Kierownik(int zarobki, String imie, String nazwisko, LocalDate dataZatrudnienia) {
        super.zarobki = zarobki;
        super.imie = imie;
        super.nazwisko = nazwisko;
        super.dataZatrudnienia = dataZatrudnienia;
        wydziałKierownika = null;

    }

    public void setWydziałKierownika(Wydział wydziałKierownika) throws KierownikMaJużWydziałException {
        if(this.wydziałKierownika != null){
            throw new KierownikMaJużWydziałException();
        }
        else {
            this.wydziałKierownika = wydziałKierownika;
        }

    }

    private Wydział wydziałKierownika;

    public Kierownik() {
        this.wydziałKierownika = wydziałKierownika;
    }



    public Set<Programista> znajdzWolnychProgramistow(){
        Set<Programista> myListOfProgrammers = new HashSet<>();
        myListOfProgrammers = wydziałKierownika.znajdzWolnychProgramistow();
        return myListOfProgrammers;
    }

    public void przypiszProjekt(Programista programista, Projekt nazwaProjektu){
        sprawdzSklad(programista);
        programista.setNazwaProjektu(java.util.Optional.ofNullable(nazwaProjektu));
    }

    public void stwórzNowyProjekt(Projekt nazwaProjektu){
        Set<Programista> wolniProgramisci = znajdzWolnychProgramistow();
        for(Programista programista : wolniProgramisci){
            programista.setNazwaProjektu(java.util.Optional.ofNullable(nazwaProjektu));
        }
    }

    public void skończProjekt(Projekt nazwaProjekt){
        for(PracownikWydziału pracownik : wydziałKierownika.getListaPracownikowWydziału()){
            if(pracownik.stanowisko.equals(Stanowisko.PROGRAMISTA)){
                Programista programista = (Programista) pracownik;
                if(programista.getNazwaProjektu().equals(nazwaProjekt)){
                    programista.setNazwaProjektu(Optional.empty());
                }
            }
        }
    }

    public Wydział getWydziałKierownika() {
        return wydziałKierownika;
    }

    public void  przyznajPodwyzke(List<PracownikWydziału> pracownik, int sumaPodwyzki){
        for(PracownikWydziału p: pracownik){
            sprawdzSklad(p);
            p.setPremieSum(sumaPodwyzki);
        }
    }

    public void awans(PracownikWydziału pracownikWydziału, Stanowisko stanowisko){
        sprawdzSklad(pracownikWydziału);
        pracownikWydziału.setStanowisko(stanowisko);
    }

    private void sprawdzSklad(PracownikWydziału pracownik){
        if(!this.wydziałKierownika.getListaPracownikowWydziału().contains(pracownik)){
            throw new ZłyWydziałException();
        }
    }
}
