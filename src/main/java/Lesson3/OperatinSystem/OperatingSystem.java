package Lesson3.OperatinSystem;

public class OperatingSystem {

    public static OperatingSystem operatingSystem;

    private OperatingSystem(){}

    //public static OperatingSystem initialize
    public void login(String username, String password){
        System.out.println("zaologowano");
    }
    public void logout(){
        System.out.println("wylogowano");
    }
}
