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
        if (checkVacantPlace()) {
           for (int i = 0; i < book.length; i++){
              if (book[i] == null){
                  book[i] = employee;
                  break;
              }
           }
        } else {
            System.out.println( "В списке нет места");
        }
    }

    public void deleteEmployee(int id){
        boolean noEmployee = true;
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null && book[i].getId() == id) {
                book[i] = null;
                noEmployee = false;
                System.out.print("Сотрудник с номером " + id + " удален");
                System.out.println();
                break;
            }
        }
        if (noEmployee) {
            System.out.println("Сотрудника с номером " + id + " нет в списке");
        }
    }

    public void printBook(){
        if (!isEmpty()) {
            for (Employee employee: book) {
                if (employee != null) {
                    System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary());
                }
            }
        } else {
            System.out.println("Список пуст. Добавьте сотрудника.");
        }

    }

    public String employeeMinSalaryByDep(int depNumber) {
        double minSalary = Integer.MAX_VALUE;
        String fullName = "";
        if (!isEmpty()) {
            for (Employee employee : book) {
                if (employee != null && employee.getDepartment() == depNumber && minSalary >= employee.getSalary()) {
                    minSalary = employee.getSalary();
                    fullName = employee.getFullName();
                }
            }

        } else {
            System.out.println("Список пуст. Добавьте сотрудника");
        }
        return fullName;
    }

    public String employeeMaxSalaryByDep(int depNumber) {
        double maxSalary = 0;
        String fullName = "";
        if (!isEmpty()) {
            for (Employee employee : book) {
                if (employee != null && employee.getDepartment() == depNumber && maxSalary < employee.getSalary()) {
                    fullName = employee.getFullName();
                }
            }
        } else {
            System.out.println("Список пуст. Добавьте сотрудника");
        }
        return fullName;
    }

    public double costSalaryByDep(int depNumber) {
        double costSalary = 0;
        if (!isEmpty()) {
            for (Employee employee : book) {
                if (employee != null && employee.getDepartment() == depNumber) {
                    costSalary += employee.getSalary();
                }
            }
        }
        return costSalary;
    }

    public double averageSalaryByDep(int depNumber) {
        int count = 0;
        double averageSalary = 0;
        for (Employee employee : book) {
                if (employee != null && employee.getDepartment() == depNumber) {
                    count++;
                    averageSalary += employee.getSalary();
                }
            }

        if (averageSalary == 0) {
            System.out.println("Список пуст.");
        }
        return averageSalary / count;
    }

    public void indexSalaryByDep(int depNumber, double index) {
        double i = index / 100;

        if (!isEmpty()) {
            for (Employee employee : book) {
                if (employee != null && employee.getDepartment() == depNumber) {
                    employee.setSalary(employee.getSalary() + employee.getSalary() * i);
                }
            }
        }
    }

    public void employeeWithLess(double trendSalary) {

        if (isEmpty()) {
                System.out.println("Список пуст.");
                System.exit(0);
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
            System.exit(0);
        }
        for (Employee employee : book) {
            if (employee != null && employee.getSalary() >= trendSalary) {
                System.out.println(employee.getId() + " - " + employee.getFullName() + " - " + employee.getSalary());
            }
        }
    }

    public Employee getById(int id) {
        boolean noEmployee = true;
        Employee em = null;
        if (!isEmpty()) {
            for (Employee employee : book) {
                if (employee != null && employee.getId() == id) {
                    em =  employee;
                    noEmployee = false;
                }
            }
            if (noEmployee) {
                System.out.println("Сотрудника с таким id нет в списке");
            }
        }
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
