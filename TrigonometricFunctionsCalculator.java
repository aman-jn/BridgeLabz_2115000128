import java.util.Scanner;

public class TrigonometricFunctionsCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an angle in degrees: ");
        double angleInDegrees = scanner.nextDouble();
        double[] trigValues = calculateTrigonometricFunctions(angleInDegrees);
        System.out.printf("Sine of %.2f°: %.4f%n", angleInDegrees, trigValues[0]);
        System.out.printf("Cosine of %.2f°: %.4f%n", angleInDegrees, trigValues[1]);
        System.out.printf("Tangent of %.2f°: %.4f%n", angleInDegrees, trigValues[2]);

        scanner.close();
    }

    public static double[] calculateTrigonometricFunctions(double angle) {
        double angleInRadians = Math.toRadians(angle);
        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);
        return new double[] { sine, cosine, tangent };
    }
}
