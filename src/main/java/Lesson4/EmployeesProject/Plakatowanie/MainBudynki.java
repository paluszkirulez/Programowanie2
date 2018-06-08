package Lesson4.EmployeesProject.Plakatowanie;

import java.util.Comparator;
import java.util.LinkedList;

public class MainBudynki {
    public static void main(String[] args) {
        BudynkiList mojaLista = new BudynkiList();
        mojaLista.add(1,2);
        mojaLista.add(1,3);
        mojaLista.add(2,2);
        mojaLista.add(2,5);
        mojaLista.add(1,4);
        int liczbaPlakatow = 0;


        if(mojaLista.getMinH()!=0){
            liczbaPlakatow = liczbaPlakatow+1;
            mojaLista.getMojeBudynki().stream().forEach(x->x.setMax_h(x.max_h-mojaLista.getMinH()));
            for (Budynki i: mojaLista.getMojeBudynki()) {
                System.out.println(i.max_h);

            }
        }
    }
}
