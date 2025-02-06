import java.util.*;
class Course{
    String name;
    List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("Course: " + name + " - Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println(student.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void displayCourses() {
        System.out.println("Student: " + name + "  Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course.name);
        }
    }
}

class School {
    String name;
    List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + name + "  Students:");
        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}

public class SchoolManagement {
    public static void main(String[] args) {
        Scanner adi = new Scanner(System.in);

        System.out.print("Enter school name: ");
        String schoolName = adi.nextLine();
        School school = new School(schoolName);

        System.out.print("Enter number of students: ");
        int numStudents = adi.nextInt();
        adi.nextLine();

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String studentName = adi.nextLine();
            Student student = new Student(studentName);
            school.addStudent(student);
            studentList.add(student);
        }

        System.out.print("Enter number of courses: ");
        int numCourses = adi.nextInt();
        adi.nextLine();

        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter course name: ");
            String courseName = adi.nextLine();
            courseList.add(new Course(courseName));
        }

        for (Student student : studentList) {
            System.out.println("Enrolling courses for " + student.name);
            for (Course course : courseList) {
                System.out.print("Enroll in " + course.name + "? (yes/no): ");
                String response = adi.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    student.enrollInCourse(course);
                }
            }
        }

        System.out.println();
        school.displayStudents();
        for (Student student : studentList) {
            student.displayCourses();
        }
        for (Course course : courseList) {
            course.displayEnrolledStudents();
        }
        adi.close();
    }
}
