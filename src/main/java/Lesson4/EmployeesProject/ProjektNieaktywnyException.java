package Lesson4.EmployeesProject;

public class ProjektNieaktywnyException extends Exception {
    public ProjektNieaktywnyException() {
        System.err.println("projekt jest już zakończony");;
    }
}
