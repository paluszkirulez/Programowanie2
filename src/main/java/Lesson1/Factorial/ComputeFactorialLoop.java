package Lesson1.Factorial;

public class ComputeFactorialLoop {
    public int computeFactorialLoop(int factorial){
        int returnInt=1;
        for (int i =1 ; i<=factorial;i++){
            returnInt = returnInt * i;
        }
        return returnInt;
    }
}
