class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        if (CGPA >= 0 && CGPA <= 4.0) {
            this.CGPA = CGPA;
        }
    }

    public void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    private String thesisTitle;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String thesisTitle) {
        super(rollNumber, name, CGPA);
        this.thesisTitle = thesisTitle;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Thesis Title: " + thesisTitle);
    }
}

public class Student1 {
    public static void main(String[] args) {
        Student student = new Student(101, "John Doe", 3.75);
        student.display();
        student.setCGPA(3.85);
        System.out.println("Updated CGPA: " + student.getCGPA());

        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Alice Smith", 3.90, "Quantum Computing Advancements");
        pgStudent.display();
    }
}
