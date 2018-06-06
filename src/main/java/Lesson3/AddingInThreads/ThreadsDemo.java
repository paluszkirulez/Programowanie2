package Lesson3.AddingInThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadsDemo {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();

        Scanner myScanner = new Scanner(System.in);
        int i =100;
        do{
            if (myScanner.nextInt()!=-1){
                System.out.println(myList);
                myList.add(myScanner.nextInt());
            }
            else {
                new SymulatorImplements(myList).run();
                myList = new ArrayList<>();
            }
            i++;
        } while (i<100);
        Thread t2 = new Thread(new SymulatorImplements(myList));
        myList.add(10);
        //System.out.println(myList);
        myList.add(10);
        t2.start();

    }
}
