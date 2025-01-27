import java.util.Scanner;

public class HandshakeCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the numberOfStudents: ");
        int numberOfStudents = scanner.nextInt();
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.println("The number of possible handshakes is: " + maxHandshakes);
        scanner.close();
    }
}
