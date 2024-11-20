package Entites;

public class user {
    private String empname;
    private int empid;
    private double empsalary;
    private int empage;

    public user() {
    }

    public user(int empid, String empname, double empsalary, int empage) {
        this.empid = empid;
        this.empname = empname;
        this.empsalary = empsalary;
        this.empage = empage;
    }

    @Override
    public String toString() {
        return "user{" +
                "empname='" + empname + '\'' +
                ", empid=" + empid +
                ", empsalary=" + empsalary +
                ", empage=" + empage +
                '}';
    }
}
