import java.util.*;
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Final Price: " + (price + calculateTax() - calculateDiscount()));
    }

    public abstract double calculateTax();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "Tax: 15%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Tax: 5%";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public double calculateTax() {
        return 0;
    }
}


public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(201, "Laptop", 1000));
        products.add(new Clothing(202, "T-Shirt", 50));
        products.add(new Groceries(203, "Apples", 30));

        for (Product product : products) {
            product.displayDetails();
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println("----------------------");
        }
    }
}
