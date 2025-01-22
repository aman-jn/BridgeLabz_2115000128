import java.util.Scanner;
public class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter the base of the triangle in inches: ");
        double baseInInches = scanner.nextDouble(); 
        System.out.print("Enter the height of the triangle in inches: ");
        double heightInInches = scanner.nextDouble();
        double areaInInches = 0.5 * baseInInches * heightInInches;
        double areaInCm = areaInInches * 6.4516;
        System.out.printf("The area of the triangle is %.2f square inches and %.2f square centimeters\n", areaInInches, areaInCm);  
        scanner.close();
    }
}