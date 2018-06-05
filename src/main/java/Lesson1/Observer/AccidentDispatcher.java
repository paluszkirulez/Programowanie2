package Lesson1.Observer;

import java.util.Observable;

public class AccidentDispatcher extends Observable {
    private TypeOfAccident accidentType;

    public void setAccidentType(TypeOfAccident accidentType) {
        this.accidentType = accidentType;
        setChanged();
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(accidentType);
    }
}
