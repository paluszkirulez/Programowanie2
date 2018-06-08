package Lesson4.EmployeesProject;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Przedsiębiorstwo {
    private Set<Kierownik> kieronictwo;
    private String nazwaPrzedsiębiorstwa;
    private int dochod;
    private HashMap<Kierownik, Projekt> mapaProjektow;
    private HashMap<Projekt, Kierownik> mapaProjektyKierownicy;
    private Set<Projekt> projektyZakonczone;
    private Set<Zamówienie> zamowienia;
    private HashMap<Zamówienie,String> odrzuconeZamowienia;
    private boolean isResourceManagementProper = true;

    public Set<Kierownik> getKieronictwo() {
        return kieronictwo;
    }

    public void setKieronictwo(Set<Kierownik> kieronictwo) {
        this.kieronictwo = kieronictwo;
    }

    public Przedsiębiorstwo(String nazwaPrzedsiębiorstwa) {
        this.nazwaPrzedsiębiorstwa = nazwaPrzedsiębiorstwa;
        mapaProjektow = new HashMap<>();
        mapaProjektyKierownicy = new HashMap<>();
        projektyZakonczone = new HashSet<>();
        zamowienia = new HashSet<>();
        kieronictwo = new HashSet<>();
    }

    public void rozpocznijNowyProjekt(Kierownik kierownik, Projekt projekt) throws KierownikZajetyException, BrakDzialuException {
        if (!kieronictwo.contains(kierownik)) throw new BrakDzialuException();
        else if (mapaProjektow.containsKey(kierownik)) throw new KierownikZajetyException();
        else {
            kierownik.stwórzNowyProjekt(projekt);
            mapaProjektow.put(kierownik, projekt);
            mapaProjektyKierownicy.put(projekt, kierownik);
        }
    }

    public void skonczBiezacyProjekt(Projekt projekt) throws ProjektNieaktywnyException {
        if (projektyZakonczone.contains(projekt)) throw new ProjektNieaktywnyException();
        mapaProjektyKierownicy.get(projekt).skończProjekt(projekt);
        Optional<PracownikWydziału> PracownikSprzedawca = mapaProjektyKierownicy.get(projekt)
                .getWydziałKierownika().getListaPracownikowWydziału().stream()
                .filter(pracownikWydziału -> pracownikWydziału.stanowisko.equals(Stanowisko.SPRZEDAWCA)).findFirst();
        PracownikSprzedawca.ifPresent(d -> ((Sprzedawca) d).sprzedaj(projekt));
        dochod = dochod + projekt.getCenaOprogramowania();
        projekt.setCzySkonczony(true);
        projektyZakonczone.add(projekt);

    }

    public void podzielWydzial(Kierownik kierownik, String nazwaNowegoWydziału, Wydział wydział) throws BrakPracownikaException, PracownikJuzZatrudnionyException, KierownikMaJużWydziałException {
        Set<Programista> freeProgrammers = wydział.znajdzWolnychProgramistow();
        Wydział nowyWydzial = new Wydział(nazwaNowegoWydziału);
        for (Programista p : freeProgrammers) {
            wydział.zwolnij(p);
            nowyWydzial.zatrudnij(p);
        }
        if (kierownik.getWydziałKierownika() != null) throw new KierownikMaJużWydziałException();
        else kierownik.setWydziałKierownika(nowyWydzial);
    }

    public void zwolnijNiepotrzebnych() throws BrakPracownikaException {
        for (Kierownik k : kieronictwo) {
            Set<Programista> listaWolnychProgramistowKierownika = k.znajdzWolnychProgramistow();
            for (Programista p : listaWolnychProgramistowKierownika) {
                k.getWydziałKierownika().zwolnij(p);
            }

        }
    }

    public void zakończWszystkiePoDeadline() {
        for (Projekt p : mapaProjektyKierownicy.keySet()) {
            if (p.getDeadline().isBefore(LocalDate.now())) {
                p.setCzySkonczony(true);
                p.przecenProgram(30);
                projektyZakonczone.add(p);

            }
        }
    }

    public int przyjmijZamowienie(Zamówienie zamówienie) throws BrakPracownikaException, PracownikJuzZatrudnionyException, KierownikMaJużWydziałException {
        zamowienia.add(zamówienie);
        Set<Projekt> projektyObecnychZmowien = zamowienia.stream().flatMap(x->x.getProjekty().stream()).collect(Collectors.toSet());
        for(Projekt x : zamówienie.getProjekty()){
            if(projektyObecnychZmowien.contains(x)){
                Projekt staryProjekt = projektyObecnychZmowien.stream().filter(p->p.equals(x)).findFirst().get();
                if(x.getDeadline().isAfter(staryProjekt.getDeadline())){
                    staryProjekt = x;
                }
                else {
                    System.out.println("Nie można skrócić czasu trwania projektu!");
                }
                projektyObecnychZmowien.stream().
                        filter(p->p.getDeadline().isBefore(zamówienie.getExactProjekt(p).getDeadline())).
                        forEach(p->p=zamówienie.getExactProjekt(p));
            }
            else {

                Kierownik wolnyKierownik = kieronictwo.stream().filter(k->!mapaProjektow.containsKey(k)).findFirst().get();
                mapaProjektow.put(wolnyKierownik,x);
                if(wolnyKierownik.getWydziałKierownika()==null){
                    stworzNowyWydzial(5,wolnyKierownik,"wydział kierownika "+wolnyKierownik.getImie());
                }
            }
        }





        if(zamowienia.contains(zamówienie)) {
            if(zamówienie.getProjekty().stream()
                    .filter(x->x.getDeadline()
                            .isBefore(zamowienia.stream().filter(c->c.equals(zamówienie)).findFirst().get().getDataZamowienia()))
                    .findFirst().isPresent()) {
                System.out.println("Nie można skrócić czasu trwania projektu!");
                return -1;
            }
            else {
               // zamowienia.stream().filter(x->x.equals(zamówienie)).findFirst().get().getProjekty().stream().
            }


        }
        return -1;
    }

    public void odrzucZamowienia(Zamówienie zamówienie, String powodOdrzucenia) throws brakPowoduOdrzucenia {
        if(powodOdrzucenia.length()>0){
            odrzuconeZamowienia.put(zamówienie,powodOdrzucenia);
        }
        else {
            throw new brakPowoduOdrzucenia();
        }

    }

    public void AwansujNaKierownika(Wydział wydział){
        Set<PracownikWydziału> listaPracownikow = wydział.getListaPracownikowWydziału();
        PracownikWydziału najlepszyPracownik;
        najlepszyPracownik = listaPracownikow.stream().min(Comparator.comparing(PracownikWydziału::getDataZatrudnienia)).orElse(null);

        kieronictwo.add(new Kierownik(
                najlepszyPracownik.getZarobki()+najlepszyPracownik.getZarobki()*50/100,
                najlepszyPracownik.getImie(),
                najlepszyPracownik.getNazwisko(),
                najlepszyPracownik.getDataZatrudnienia()));

    }

    public HashMap<Kierownik, Projekt> getMapaProjektow() {
        return mapaProjektow;
    }

    public void zatrudnijKierownika(Kierownik kierownik) throws KierownikJestJuzZatrudnionyException {
        if(kieronictwo.contains(kierownik)){throw new KierownikJestJuzZatrudnionyException();}
        else {
            kieronictwo.add(kierownik);
        }
        long liczbaKierownikowBezProjektu = kieronictwo.stream().filter(kierownik1 -> mapaProjektow.containsKey(kierownik1)).count();
        if(liczbaKierownikowBezProjektu>2.0){
            System.out.println("W FIRMIE JEST 4 KIEROWNIKÓW BEZ PROJEKTU, MOŻLIWE ZŁE ZARZĄDZANIE ZASOBAMI");
            isResourceManagementProper = false;
        }
    }

    public void stworzNowyWydzial(int liczbaProgramistow, Kierownik kierownik, String nazwaWydziału) throws KierownikMaJużWydziałException, PracownikJuzZatrudnionyException, BrakPracownikaException {
        try {
            zatrudnijKierownika(kierownik);
        } catch (KierownikJestJuzZatrudnionyException e) {
            System.out.println("kieronwik juz zatrudniony");
        }
        finally {
            int check = 0;
            for(Kierownik k : kieronictwo){
                if(k.znajdzWolnychProgramistow().stream().count()>liczbaProgramistow){
                    podzielWydzial(kierownik,nazwaWydziału,k.getWydziałKierownika());
                    check = 1;
                }
            }
            if(check == 0){
                Wydział nowyWydzial = new Wydział(nazwaWydziału);
                kierownik.setWydziałKierownika(nowyWydzial);
            }
        }
    }

}
