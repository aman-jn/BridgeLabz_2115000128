import java.util.*;
class Faculty{
    String name;
    
    public Faculty(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    String name;
    List<Faculty> facultyMembers;

    public Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void display() {
        System.out.println("Department: " + name);
        for (Faculty faculty : facultyMembers) {
            faculty.display();
        }
    }
}

class University {
    String name;
    List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFacultyToDepartment(String departmentName, Faculty faculty) {
        for (Department dept : departments) {
            if (dept.name.equals(departmentName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department not found.");
    }

    public void display() {
        System.out.println("University: " + name);
        for (Department dept : departments) {
            dept.display();
        }
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Scanner adi = new Scanner(System.in);

        System.out.print("Enter university name: ");
        String universityName = adi.nextLine();
        University university = new University(universityName);

        System.out.print("Enter number of departments: ");
        int numDepartments = adi.nextInt();
        adi.nextLine();

        for (int i = 0; i < numDepartments; i++) {
            System.out.print("Enter department name: ");
            String deptName = adi.nextLine();
            university.addDepartment(deptName);
        }

        System.out.print("Enter number of faculty members: ");
        int numFaculty = adi.nextInt();
        adi.nextLine();

        List<Faculty> facultyList = new ArrayList<>();
        for (int i = 0; i < numFaculty; i++) {
            System.out.print("Enter faculty name: ");
            String facultyName = adi.nextLine();
            facultyList.add(new Faculty(facultyName));
        }

        for (Faculty faculty : facultyList) {
            System.out.print("Assign " + faculty.name + " to which department? ");
            String deptName = adi.nextLine();
            university.addFacultyToDepartment(deptName, faculty);
        }

        System.out.println();
        university.display();
        adi.close();
    }
}