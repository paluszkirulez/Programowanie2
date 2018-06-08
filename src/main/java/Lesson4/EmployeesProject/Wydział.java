package Lesson4.EmployeesProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Wydział {
    private String nazwaWydziału;
    private Set<PracownikWydziału> listaPracownikowWydziału;

    public Set<PracownikWydziału> getListaPracownikowWydziału() {
        return listaPracownikowWydziału;
    }

    public Wydział(String nazwaWydziału) {
        this.nazwaWydziału = nazwaWydziału;
        this.listaPracownikowWydziału = new HashSet<>();
    }

    public void przyznajPremie(int premia){
        for(PracownikWydziału pracownik : this.listaPracownikowWydziału){
            pracownik.setPremieSum(premia);
        }
    }

    public void zatrudnij(PracownikWydziału pracownikWydziału) throws PracownikJuzZatrudnionyException {
        int jusjest = 0;
        if(listaPracownikowWydziału.contains(pracownikWydziału)) {
            jusjest = 1;
            throw new PracownikJuzZatrudnionyException();

        }
        else {
            if(pracownikWydziału.stanowisko.equals(Stanowisko.SPRZEDAWCA)){
                for(PracownikWydziału pracownik : listaPracownikowWydziału){
                    if(pracownik.stanowisko.equals(Stanowisko.SPRZEDAWCA)){
                        jusjest = 1;
                        throw new SprzedawcaZatrudnionyException();
                    }
                }

            }

        }
        if(jusjest == 0) listaPracownikowWydziału.add(pracownikWydziału);
    }

    public void zwolnij(PracownikWydziału pracownikWydziału) throws BrakPracownikaException {
        if(!listaPracownikowWydziału.contains(pracownikWydziału)) {
            throw new BrakPracownikaException();
        }
        else {
            listaPracownikowWydziału.remove(pracownikWydziału);
        }
    }

    public Set<Programista> znajdzWolnychProgramistow(){
        Set<Programista> myListOfProgrammers = new HashSet<>();
        for(PracownikWydziału p : getListaPracownikowWydziału()){
            if (p.stanowisko.equals(Stanowisko.PROGRAMISTA)){
                Programista programista = (Programista)p;
                if(!programista.getNazwaProjektu().isPresent()){
                    myListOfProgrammers.add(programista);
                }
            }
        }
        return myListOfProgrammers;
    }

}
