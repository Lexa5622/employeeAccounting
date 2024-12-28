package com.company;

public class Employee {
    private static int count;

    private int id ;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        this.id = ++count;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fullName, department);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Employee otherEmployee = (Employee) obj;
        return fullName.equals(otherEmployee.fullName) && department == otherEmployee.department;
    }

    @Override
    public String toString() {
        return id + ". " + fullName + " " + salary + ", Отдел " + department + ".";
    }
}
