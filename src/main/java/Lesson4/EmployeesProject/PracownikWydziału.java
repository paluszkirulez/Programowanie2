package Lesson4.EmployeesProject;

public abstract class PracownikWydziału  extends Pracownik{
    protected int premieSum;
    protected Stanowisko stanowisko;

    public void setPremieSum(int premieSum) {
        this.premieSum = this.premieSum+ premieSum;

    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getPremieSum() {
        return premieSum;
    }

}
