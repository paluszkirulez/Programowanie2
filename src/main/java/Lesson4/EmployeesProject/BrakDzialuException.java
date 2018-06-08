package Lesson4.EmployeesProject;

public class BrakDzialuException extends Exception {
    public BrakDzialuException() {
        System.err.println("nie ma takiego kierownika, zacznij z poczatku");
    }
}
