package Lesson4.EmployeesProject.Plakatowanie;

import java.util.LinkedList;

public class BudynkiList {
    LinkedList<Budynki> mojeBudynki;
    int minH = Integer.MAX_VALUE;
    int maxH = 0;

    public void add(int x, int y){
        setMojeBudynki(new Budynki(x,y));
        setMaxH(y);
        setMinH(y);
    }

    public int getMinH() {
        return minH;
    }

    public LinkedList<Budynki> getMojeBudynki() {
        return mojeBudynki;
    }

    public int getMaxH() {
        return maxH;
    }

    public BudynkiList() {
        this.mojeBudynki = new LinkedList<>();
    }

    public void setMaxH(int maxH) {
        if(maxH> this.maxH){
            this.maxH = maxH;
        }
    }
    public void setMinH(int minH){
        if(minH<this.minH){
            this.minH=minH;
        }
    }

    public void setMojeBudynki(Budynki budynki) {
        this.mojeBudynki.add(budynki);
    }
}
