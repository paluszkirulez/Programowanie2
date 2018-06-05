package Lesson1.Factorial;

public class ComputeFactorialRecurent {
    public int computeFactorial (int factorial){
        int returnInt=factorial;
        if(factorial ==1){
            return 1;
        }
        else{
            returnInt = returnInt * computeFactorial(factorial-1);
        }
        return returnInt;
    }
}
