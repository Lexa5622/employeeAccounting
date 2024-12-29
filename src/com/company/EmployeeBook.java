package com.company;

public class EmployeeBook {
    private Employee[] book;
    private int length;

    public EmployeeBook(int length) {
        this.book = new Employee[length];
    }

    public Employee[] getBook() {
        return book;
    }

    public int getLength() {
        return book.length;
    }

    public void addEmployee(Employee employee){
        if (!checkVacantPlace()) {
            System.out.println( "В списке нет места");
            return;
        }
        for (int i = 0; i < book.length; i++){
            if (book[i] == null){
                book[i] = employee;
                break;
            }
        }
    }

    public void deleteEmployee(int id){
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null && book[i].getId() == id) {
                book[i] = null;
                System.out.print("Сотрудник с номером " + id + " удален");
                System.out.println();
                return;
            }
        }
        System.out.println("Сотрудника с номером " + id + " нет в списке");
    }

    public void printBook(){
        if (isEmpty()) {
            System.out.println("Список пуст. Добавьте сотрудника.");
            return;
        }
        for (Employee employee: book) {
            if (employee != null) {
                System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary());
            }
        }
    }

    public String employeeMinSalaryByDep(int depNumber) {
        if (isEmpty()) {
            return "Список пуст. Добавьте сотрудника";
        }
        double minSalary = Integer.MAX_VALUE;
        String fullName = "";
        for (Employee employee : book) {
            if (employee != null && employee.getDepartment() == depNumber && minSalary >= employee.getSalary()) {
                minSalary = employee.getSalary();
                fullName = employee.getFullName();
            }
        }
        return fullName;
    }

    public String employeeMaxSalaryByDep(int depNumber) {
        if (isEmpty()) {
            return "Список пуст. Добавьте сотрудника";
        }
        double maxSalary = 0;
        String fullName = "";
        for (Employee employee : book) {
            if (employee != null && employee.getDepartment() == depNumber && maxSalary < employee.getSalary()) {
                fullName = employee.getFullName();
            }
        }
        return fullName;
    }

    public double costSalaryByDep(int depNumber) {
        if (isEmpty()) {
            System.out.println("Список пуст.");
        }
        double costSalary = 0;
        for (Employee employee : book) {
            if (employee != null && employee.getDepartment() == depNumber) {
                costSalary += employee.getSalary();
            }
        }
        return costSalary;
    }

    public double averageSalaryByDep(int depNumber) {
        if (isEmpty()) {
            System.out.println("Список пуст.");
        }
        int count = 0;
        double averageSalary = 0;
        for (Employee employee : book) {
                if (employee != null && employee.getDepartment() == depNumber) {
                    count++;
                    averageSalary += employee.getSalary();
                }
            }
        return averageSalary / count;
    }

    public void indexSalaryByDep(int depNumber, double index) {
        double percentIndex = index / 100;
        if (isEmpty()) {
            return;
        }
        for (Employee employee : book) {
            if (employee != null && employee.getDepartment() == depNumber) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * percentIndex);
            }
        }
    }

    public void employeeWithLess(double trendSalary) {
        if (isEmpty()) {
                System.out.println("Список пуст.");
                return;
        }
        for (Employee employee : book) {
            if (employee != null && employee.getSalary() <= trendSalary) {
                System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary());
            }
        }
    }

    public void employeeWithMore(double trendSalary) {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        for (Employee employee : book) {
            if (employee != null && employee.getSalary() >= trendSalary) {
                System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary());
            }
        }
    }

    public Employee getById(int id) {
        if (isEmpty()) {
            System.out.println("Список пуст");
        }
        Employee em = null;
        for (Employee employee : book) {
            if (employee != null && employee.getId() == id) {
                em =  employee;
                break;
            }
        }
        System.out.println("Сотрудника с таким id нет в списке");
        return em;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        int count = 0;
        for (Employee employee : book) {
            if (employee == null) {
                count++;
            }
        }
        if (count < book.length) {
            isEmpty = false;
        }
        return isEmpty;
    }

    public boolean checkVacantPlace() {
        for (Employee employee : book) {
            if (employee == null) {
                return true;
            }
        }
        return false;
    }
}
