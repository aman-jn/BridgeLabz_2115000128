public class Product1 {
    private static double discount = 10.0;
    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product1(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails() {
        if (this instanceof Product1) {
            System.out.println("Product ID: " + this.productID);
            System.out.println("Product Name: " + this.productName);
            System.out.println("Price: $" + this.price);
            System.out.println("Quantity: " + this.quantity);
            System.out.println("Discount: " + discount + "%");
        } else {
            System.out.println("Invalid product object.");
        }
    }

    public static void main(String[] args) {
        Product1 product1 = new Product1("P001", "Laptop", 1200.00, 2);
        Product1 product2 = new Product1("P002", "Smartphone", 800.00, 5);

        product1.displayProductDetails();
        System.out.println();
        product2.displayProductDetails();

        System.out.println("\nUpdating discount to 15%...");
        updateDiscount(15.0);

        System.out.println();
        product1.displayProductDetails();
        System.out.println();
        product2.displayProductDetails();
    }
}
