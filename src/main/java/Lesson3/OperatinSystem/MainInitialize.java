package Lesson3.OperatinSystem;

public class MainInitialize {
    public static void main(String[] args) {
        OpSys mySystem = OperatingSystem.initialize();
        OpSys mySystemCheckAccount = new OperatingSystemAddOnConcrete(mySystem);

        mySystem.login("bartek","bartek");
        mySystem.logout();

        mySystemCheckAccount.login("bartek","bartek");

    }
}
