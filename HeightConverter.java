import java.util.Scanner;
public class HeightConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double heightInCm = scanner.nextDouble();
        double totalInches = heightInCm / 2.54;
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;
        System.out.printf("Your height in cm is %.2f while in feet is %d and inches is %.2f\n", heightInCm, feet, inches);
        scanner.close();
    }
}