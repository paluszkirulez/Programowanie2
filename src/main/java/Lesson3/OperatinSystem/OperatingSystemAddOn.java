package Lesson3.OperatinSystem;

public abstract class OperatingSystemAddOn implements OpSys {
    protected OpSys opsys;

    public OperatingSystemAddOn(OpSys opsys){
        this.opsys = opsys;
    }

    @Override
    public void login(String username, String password) {
        if(username.equals(password)){
            throw new SameUsernameAndPasswordException();
        }
        else System.out.println("zaologowano");
    }

    @Override
    public void logout() {

    }
}
