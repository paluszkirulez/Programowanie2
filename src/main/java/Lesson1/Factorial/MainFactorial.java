package Lesson1.Factorial;

public class MainFactorial {
    public static void main(String[] args) {
        System.out.println(new ComputeFactorialLoop().computeFactorialLoop(3));
        System.out.println(new ComputeFactorialRecurent().computeFactorial(3));
    }
}
