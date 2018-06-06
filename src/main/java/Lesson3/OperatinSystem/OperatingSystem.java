package Lesson3.OperatinSystem;

public class OperatingSystem implements OpSys {

    public static OperatingSystem operatingSystem;

    private OperatingSystem(){}

    public static OperatingSystem initialize(){
        if(operatingSystem ==null){
            System.out.println("włączony");
           operatingSystem =  new OperatingSystem();
        }
        return operatingSystem;
    }
    public void login(String username, String password){
        System.out.println("zaologowano");
    }
    public void logout(){
        System.out.println("wylogowano");
    }
}
