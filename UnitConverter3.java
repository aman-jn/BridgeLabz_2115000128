import java.util.Scanner;

public class UnitConverter3 {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        System.out.println("Fahrenheit to Celsius: " + convertFahrenheitToCelsius(fahrenheit));

        System.out.print("Enter value in Celsius: ");
        double celsius = scanner.nextDouble();
        System.out.println("Celsius to Fahrenheit: " + convertCelsiusToFahrenheit(celsius));

        System.out.print("Enter value in pounds: ");
        double pounds = scanner.nextDouble();
        System.out.println("Pounds to Kilograms: " + convertPoundsToKilograms(pounds));

        System.out.print("Enter value in kilograms: ");
        double kilograms = scanner.nextDouble();
        System.out.println("Kilograms to Pounds: " + convertKilogramsToPounds(kilograms));

        System.out.print("Enter value in gallons: ");
        double gallons = scanner.nextDouble();
        System.out.println("Gallons to Liters: " + convertGallonsToLiters(gallons));

        System.out.print("Enter value in liters: ");
        double liters = scanner.nextDouble();
        System.out.println("Liters to Gallons: " + convertLitersToGallons(liters));

        scanner.close();
    }
}
