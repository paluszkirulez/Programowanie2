package Lesson1.Observer;

import java.util.Observer;

public class ObserverExample {

    public static void main(String[] args) {
        AccidentDispatcher accidentDispatcher = new AccidentDispatcher();

        Observer statistician = new Statistician();
        Observer statistician2 = new Statistician();
        Observer statistician3 = new Statistician();

        accidentDispatcher.addObserver(statistician);
        accidentDispatcher.addObserver(statistician2);

        System.out.println("First accident (two observers):");
        accidentDispatcher.setAccidentType(TypeOfAccident.TORNADO);
        accidentDispatcher.notifyObservers();
        accidentDispatcher.addObserver(statistician3);
        System.out.println("\nSecond accident (three observers):");
        accidentDispatcher.setAccidentType(TypeOfAccident.POWÓDŹ);
        accidentDispatcher.notifyObservers();

        ((Statistician) statistician).printAllStats();

        //accidentDispatcher.deleteObserver(statistician);

        //accidentDispatcher.setAccidentType("Truck hit a tree.");
        //System.out.println("\nThird accident (statistician and agentAbw removed):");
        //accidentDispatcher.notifyObservers();
    }
}
