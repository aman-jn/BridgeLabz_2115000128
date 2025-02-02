class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    public void display() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {
    private String title;

    public Manager(int employeeID, String department, double salary, String title) {
        super(employeeID, department, salary);
        this.title = title;
    }

    public void display() {
        super.display();
        System.out.println("Title: " + title);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee employee = new Employee(1001, "Sales", 50000.00);
        employee.display();
        employee.setSalary(55000.00);
        System.out.println("Updated Salary: $" + employee.getSalary());

        Manager manager = new Manager(2001, "HR", 80000.00, "HR Manager");
        manager.display();
    }
}
