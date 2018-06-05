package Lesson2.DatabaseClient;

public class HostNotFound extends RuntimeException {
    public HostNotFound() {
        System.out.println("host not found");
        System.out.println(getStackTrace().toString());
    }
}
