public class Student {
    private static String universityName = "Global University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Student Name: " + this.name);
            System.out.println("Roll Number: " + this.rollNumber);
            System.out.println("Grade: " + this.grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + this.grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alice Johnson", 1001, "A");
        Student student2 = new Student("Bob Williams", 1002, "B");

        student1.displayStudentDetails();
        System.out.println();
        student2.displayStudentDetails();

        System.out.println();
        displayTotalStudents();

        System.out.println("\nUpdating grades...");
        student1.updateGrade("A+");
        student2.updateGrade("B+");

        System.out.println();
        student1.displayStudentDetails();
        System.out.println();
        student2.displayStudentDetails();
    }
}
