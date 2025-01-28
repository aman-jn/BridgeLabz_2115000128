import java.util.Scanner;

public class UnitConverter2 {
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value in kilometers: ");
        double kilometers = scanner.nextDouble();
        System.out.println("Kilometers to miles: " + convertKmToMiles(kilometers));

        System.out.print("Enter value in miles: ");
        double miles = scanner.nextDouble();
        System.out.println("Miles to kilometers: " + convertMilesToKm(miles));

        System.out.print("Enter value in meters: ");
        double meters = scanner.nextDouble();
        System.out.println("Meters to feet: " + convertMetersToFeet(meters));

        System.out.print("Enter value in feet: ");
        double feet = scanner.nextDouble();
        System.out.println("Feet to meters: " + convertFeetToMeters(feet));

        scanner.close();
    }
}
