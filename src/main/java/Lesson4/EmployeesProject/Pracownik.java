package Lesson4.EmployeesProject;

import java.time.LocalDate;
import java.util.Date;

public abstract class Pracownik {
    protected int zarobki;
    protected String imie;
    protected String nazwisko;
    protected LocalDate dataZatrudnienia;
    protected static int id;

    public Pracownik(){
        id = id+1;
    }

    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public Pracownik(int zarobki, String imie, String nazwisko, LocalDate dataZatrudnienia) {
        this.zarobki = zarobki;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public int getZarobki() {
        return zarobki;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public static int getId() {
        return id;
    }
}
