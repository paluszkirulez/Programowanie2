package Lesson4.EmployeesProject;

public class KierownikJestJuzZatrudnionyException extends Exception {
    public KierownikJestJuzZatrudnionyException() {
        System.out.println("Taki kierownik jest juz zatrudnion");
    }
}
