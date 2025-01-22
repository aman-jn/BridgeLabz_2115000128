
import java.util.Scanner;
class AverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        double average = (num1+num2+num3)/3;
        System.out.println("The average of the three numbers is: " + average);
    }
}
