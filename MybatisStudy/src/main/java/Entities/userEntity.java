package Entities;

public class userEntity {
    private String emp_name;
    private int emp_age;
    private double emp_salary;
    private int emp_id;

    public userEntity(String emp_id, int empAge, int empSalary, String emp_name) {
        this.emp_name = emp_name;
        this.emp_age = empAge;
        this.emp_salary = empSalary;
    }


    public String getEmp_name() {
        return emp_name;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public double getSalary() {
        return emp_salary;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public userEntity(String emp_name, int emp_age, double emp_salary, int emp_id) {
        this.emp_name = emp_name;
        this.emp_age = emp_age;
        this.emp_salary = emp_salary;
        this.emp_id = emp_id;
    }

    public userEntity() {
    }

    @Override
    public String toString() {
        return "userEntity{" +
                "emp_name='" + emp_name + '\'' +
                ", emp_age=" + emp_age +
                ", emp_salary=" + emp_salary +
                ", emp_id=" + emp_id +
                '}';
    }
}
