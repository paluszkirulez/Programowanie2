package Lesson1.Observer;

import java.util.Observable;
import java.util.Observer;

public class Ambulance implements Observer {
    public void update(Observable o, Object arg) {
        System.out.println("Ambulance going to accident: " + arg.toString());
    }
}
