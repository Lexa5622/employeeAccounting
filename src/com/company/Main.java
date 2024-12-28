package com.company;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee("Дорофеев А. Н.", 1, 35000);
        Employee employee1 = new Employee("Пупкин В. С.", 4, 40000);
        Employee employee2 = new Employee("Истомина И. Н.", 3, 30000);
        Employee employee3 = new Employee("Истомина И. K.", 3, 30000);
        Employee employee4 = new Employee("Иванов И. И.", 5, 50000);
        Employee employee5 = new Employee("Сидоров С. С.", 5, 50000);
        Employee employee6 = new Employee("Картошкин П. П.", 3, 30000);
        Employee employee7 = new Employee("Петров П. П.", 2, 25000);
        Employee employee8 = new Employee("Сушкин С. С.", 1, 35000);
        Employee employee9 = new Employee("Сталин И. В.", 2, 25000);

        employee.setSalary(40000);
        System.out.println(employee);
        System.out.println("---------------------");
        EmployeeBook book = new EmployeeBook(10);
        book.addEmployee(employee);
        book.addEmployee(employee1);
        book.addEmployee(employee2);
        book.addEmployee(employee3);
        book.addEmployee(employee4);
        book.addEmployee(employee5);
        book.addEmployee(employee6);
        book.addEmployee(employee7);
        book.addEmployee(employee8);
        book.addEmployee(employee9);

        book.deleteEmployee(5);
        System.out.println("---------------------");
        book.printBook();
        System.out.println("---------------------");
        System.out.println(book.employeeMaxSalaryByDep(1));
        System.out.println("---------------------");
        System.out.println(book.averageSalaryByDep(1));
        System.out.println("---------------------");
        System.out.println(book.costSalaryByDep(1));
        System.out.println("VBY---------------------");
        System.out.println(book.employeeMinSalaryByDep(3));
        System.out.println("---------------------");
        book.indexSalaryByDep(1, 50);
        book.printBook();
        System.out.println("-----------------------");
        book.employeeWithLess(40000);
        System.out.println("-----------------------");
        book.employeeWithMore(40000);
        System.out.println("-----------------------");
        System.out.println(book.getById(1));

    }
}
