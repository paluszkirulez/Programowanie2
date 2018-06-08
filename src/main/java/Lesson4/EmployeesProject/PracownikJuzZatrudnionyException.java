package Lesson4.EmployeesProject;

public class PracownikJuzZatrudnionyException extends Exception {
    public PracownikJuzZatrudnionyException() {
        System.err.println("pracownik juz zatrudniony");
    }
}
