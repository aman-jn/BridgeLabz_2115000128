import java.util.Scanner;

public class TravelJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the city you are traveling from: ");
        String fromCity = scanner.nextLine();
        System.out.print("Enter the city you are traveling via: ");
        String viaCity = scanner.nextLine();
        System.out.print("Enter the final destination city: ");
        String toCity = scanner.nextLine();
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = scanner.nextDouble();
        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = scanner.nextDouble();
        System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " in hours: ");
        double timeFromToVia = scanner.nextDouble();
        System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " in hours: ");
        double timeViaToFinalCity = scanner.nextDouble();
        double totalDistance = fromToVia + viaToFinalCity;
        double totalTime = timeFromToVia + timeViaToFinalCity;
        System.out.println("Journey Details:\nTraveler: " + name + "\nFrom: " + fromCity + "\nVia: " + viaCity + "\nTo: " + toCity + "\nTotal Distance: " + totalDistance + " miles\nTotal Time: " + totalTime + " hours");
        scanner.close();
    }
}
