package Lesson2.Options;

import java.util.Optional;

public class MyOptional <T> {
    private T myOptional;
    public T get() throws BrakElementuException{
        if(myOptional == null){
            throw new BrakElementuException();
        }
        return myOptional;
    }

    public boolean isSet() {
        return (myOptional==null)?false:true;
    }

    public void setMyOptional(T myOptional) {
        this.myOptional = myOptional;
    }

    static public MyOptional empty(){
        return new MyOptional();
    }

    public T getOrDefault(T myOptional){
        if(isSet()){
            return this.myOptional;
        }
        else {
            this.myOptional = myOptional;
            return myOptional;
        }

    }

    public MyOptional(T myOptional) {
        this.myOptional = myOptional;
    }

    public MyOptional() {
    }
}
