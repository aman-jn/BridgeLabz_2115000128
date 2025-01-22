import java.util.Scanner;
public class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        if (numberOfStudents < 2) {
            System.out.println("At least 2 students are required for handshakes.");
        } else {
            int numberOfHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
            System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is: " + numberOfHandshakes);
        }
        scanner.close();
    }
}
