
import java.util.*;
class Course {
    String name;
    Professor professor;
    List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("Taught by: " + professor.name);
        }
        System.out.println("Enrolled Students:");
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

    public void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void displayEnrolledCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course.name);
        }
    }
}

class Professor {
    String name;

    public Professor(String name) {
        this.name= name;
    }
}

public class UniversityManagement2 {
    public static void main(String[] args) {
        Scanner adi = new Scanner(System.in);

        System.out.print("Enter number of courses: ");
        int numCourses = adi.nextInt();
        adi.nextLine();
        List<Course> courses = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter course name: ");
            String courseName = adi.nextLine();
            courses.add(new Course(courseName));
        }

        System.out.print("Enter number of professors: ");
        int numProfessors = adi.nextInt();
        adi.nextLine();
        List<Professor> professors = new ArrayList<>();

        for (int i = 0; i < numProfessors; i++) {
            System.out.print("Enter professor name: ");
            String professorName = adi.nextLine();
            professors.add(new Professor(professorName));
        }

        for (Course course : courses) {
            System.out.print("Assign professor to " + course.name + " (enter name): ");
            String professorName = adi.nextLine();
            for (Professor professor : professors) {
                if (professor.name.equals(professorName)) {
                    course.assignProfessor(professor);
                    break;
                }
            }
        }

        System.out.print("Enter number of students: ");
        int numStudents = adi.nextInt();
        adi.nextLine();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String studentName = adi.nextLine();
            Student student = new Student(studentName);
            students.add(student);

            System.out.println("Enroll " + studentName + " in courses:");
            for (Course course : courses) {
                System.out.print("Enroll in " + course.name + "? (yes/no): ");
                String response = adi.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    student.enrollCourse(course);
                }
            }
        }

        System.out.println();
        for (Course course : courses) {
            course.displayCourseDetails();
        }
        for (Student student : students) {
            student.displayEnrolledCourses();
        }
        adi.close();
    }
}
