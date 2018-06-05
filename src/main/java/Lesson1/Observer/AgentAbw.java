package Lesson1.Observer;

import java.util.Observable;
import java.util.Observer;

public class AgentAbw implements Observer {
    public void update(Observable o, Object arg) {
        System.out.println("Monitoring accident for the good of the state: " + arg.toString());
    }
}
