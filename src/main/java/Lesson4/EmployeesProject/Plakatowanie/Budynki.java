package Lesson4.EmployeesProject.Plakatowanie;

public class Budynki {
    int max_h;
    int max_w;

    public Budynki(int max_w, int max_h) {
        this.max_h = max_h;
        this.max_w = max_w;
    }

    public int getMax_h() {
        return max_h;
    }

    public int getMax_w() {
        return max_w;
    }

    public void setMax_h(int max_h) {
        this.max_h = max_h;
    }

    public void setMax_w(int max_w) {
        this.max_w = max_w;
    }
}
