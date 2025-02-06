
import java.util.*;
class Employee {
    String name;
    String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void display() {
        System.out.println("Employee: " + name + ", Position: " + position);
    }
}

class Department {
    String name;
    ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    public void display() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            emp.display();
        }
    }
}

class Company {
    String name;
    ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName, String position) {
        for (Department dept : departments) {
            if (dept.name.equals(departmentName)) {
                dept.addEmployee(employeeName, position);
                return;
            }
        }
        System.out.println("Department not found.");
    }

    public void display() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.display();
        }
    }
}

public class CompanyManagement {
    public static void main(String[] args) {
        Scanner adi= new Scanner(System.in);

        System.out.print("Enter company name: ");
        String companyName =adi.nextLine();
        Company company = new Company(companyName);

        System.out.print("Enter number of departments: ");
        int numDepartments =adi.nextInt();
        adi.nextLine();

        for (int i = 0; i < numDepartments; i++) {
            System.out.print("Enter department name: ");
            String deptName =adi.nextLine();
            company.addDepartment(deptName);

            System.out.print("Enter number of employees in " + deptName + ": ");
            int numEmployees =adi.nextInt();
            adi.nextLine();

            for (int j= 0; j < numEmployees; j++) {
                System.out.print("Enter employee name: ");
                String empName =adi.nextLine();
                System.out.print("Enter employee position: ");
                String position =adi.nextLine();
                company.addEmployeeToDepartment(deptName, empName, position);
            }
        }

        System.out.println();
        company.display();
        adi.close();
    }
}
