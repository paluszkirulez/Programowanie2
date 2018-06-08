package Lesson4.EmployeesProject;

public class KierownikZajetyException extends Exception {
    public KierownikZajetyException() {
        System.err.println("Kierownik jest zajety");
    }
}
