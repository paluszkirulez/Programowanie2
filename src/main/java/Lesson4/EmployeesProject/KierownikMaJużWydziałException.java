package Lesson4.EmployeesProject;

public class KierownikMaJużWydziałException extends Exception {
    public KierownikMaJużWydziałException() {
        System.err.println("Kierownik ma juz wuydzial");
    }
}
