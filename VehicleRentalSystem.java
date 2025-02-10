import java.util.*;
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    public abstract double calculateRentalCost(int days);

    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Type: " + type + ", Rental Cost: " + calculateRentalCost(days) + ", Insurance Cost: " + calculateInsurance());
    }

    public abstract double calculateInsurance();
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance: 10% of rental rate";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance: 5% of rental rate";
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }
}


public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR123", 50));
        vehicles.add(new Bike("BIKE456", 20));
        vehicles.add(new Truck("TRUCK789", 100));

        int rentalDays = 5;
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails(rentalDays);
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }
            System.out.println("----------------------");
        }
    }
}