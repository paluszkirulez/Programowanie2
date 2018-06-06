package Lesson3.AddingInThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SymulatorImplements extends Thread {

        List<Integer> myList;
        SymulatorWindowsa symulatorWindowsa = new SymulatorWindowsa();

    public SymulatorImplements(List<Integer> myList) {
        this.myList = myList;


        try {
            symulatorWindowsa.sumuj(myList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
