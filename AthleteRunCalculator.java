import java.util.Scanner;
public class AthleteRunCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();
        double perimeter = calculatePerimeter(side1, side2, side3);
        int rounds = calculateRounds(perimeter, 5000);
        System.out.println("The athlete needs to complete " + rounds + " rounds to cover 5 km.");
        scanner.close();
    }

    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    public static int calculateRounds(double perimeter, double distance) {
        return (int) Math.ceil(distance / perimeter);
    }
}
