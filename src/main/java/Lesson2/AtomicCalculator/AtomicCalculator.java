package Lesson2.AtomicCalculator;



public class AtomicCalculator<T extends Number > {

    public float addNUmbers(T number1, T number2){
        float numberReturned = number1.floatValue() + number2.floatValue() ;
        return numberReturned;
    }
    public float minusNUmbers(T number1, T number2){
        float numberReturned = number1.floatValue() - number2.floatValue() ;
        return numberReturned;
    }
    public float multiplyNUmbers(T number1, T number2){
        float numberReturned = number1.floatValue() * number2.floatValue() ;
        return numberReturned;
    }
    public float divideNUmbers(T number1, T number2){
        if (number2.intValue()==0) return 0;
        float numberReturned = number1.floatValue() / number2.floatValue() ;
        return numberReturned;
    }
}
