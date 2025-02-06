import java.util.*;
class Product{
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }
}

class Order {
    int orderId;
    Customer customer;
    List<Product> products;
    static int orderCounter =1;

    public Order(Customer customer) {
        this.orderId = orderCounter++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId + ", Customer: " + customer.name);
        System.out.println("Products:");
        for (Product product : products) {
            product.display();
        }
    }
}

class Customer {
    String name;
    List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        System.out.println("Customer: " + name + " - Orders:");
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Scanner adi = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = adi.nextLine();
        Customer customer = new Customer(customerName);

        System.out.print("Enter number of products available: ");
        int numProducts = adi.nextInt();
        adi.nextLine();

        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter product name: ");
            String productName = adi.nextLine();
            System.out.print("Enter product price: ");
            double price = adi.nextDouble();
            adi.nextLine();
            productList.add(new Product(productName, price));
        }

        Order order = new Order(customer);
        System.out.println("Select products for the order:");
        for (Product product : productList) {
            System.out.print("Add " + product.name + " to order? (yes/no): ");
            String response = adi.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                order.addProduct(product);
            }
        }

        customer.placeOrder(order);

        System.out.println();
        customer.displayOrders();
        adi.close();
    }
}