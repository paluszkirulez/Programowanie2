package Lesson4.EmployeesProject;

import java.time.LocalDate;
import java.util.Objects;

public class Projekt {
    private String nazwaOprogramowania;
    private int cenaOprogramowania;
    private boolean czySkonczony;
    private LocalDate deadline;

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isCzySkonczony() {
        return czySkonczony;
    }

    public Projekt(String nazwaOprogramowania) {
        this.nazwaOprogramowania = nazwaOprogramowania;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Projekt)) return false;
        Projekt projekt = (Projekt) o;
        return cenaOprogramowania == projekt.cenaOprogramowania &&
                czySkonczony == projekt.czySkonczony &&
                Objects.equals(nazwaOprogramowania, projekt.nazwaOprogramowania);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nazwaOprogramowania, cenaOprogramowania, czySkonczony);
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setCzySkonczony(boolean czySkonczony) {
        this.czySkonczony = czySkonczony;
    }

    public int getCenaOprogramowania() {
        return cenaOprogramowania;
    }

    public void setCenaOprogramowania(int cenaOprogramowania) {
        this.cenaOprogramowania = cenaOprogramowania;
    }

    public void przecenProgram(int znizka){
        this.cenaOprogramowania = this.cenaOprogramowania - (this.cenaOprogramowania*znizka/100);
    }
}
