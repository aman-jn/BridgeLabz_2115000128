import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

public class ShoppingCart {

    Map<String, Double> productPrices = new HashMap<>();
    LinkedHashMap<String, Double> cartOrder = new LinkedHashMap<>();
    TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

    public void addProduct(String name, double price) {
        productPrices.put(name, price);
        cartOrder.put(name, price);
        sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(name);
    }

    public Map<String, Double> getProductPrices() {
        return productPrices;
    }

    public LinkedHashMap<String, Double> getCartOrder() {
        return cartOrder;
    }

    public TreeMap<Double, List<String>> getSortedByPrice() {
        return sortedByPrice;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 1200.00);
        cart.addProduct("Headphones", 150.00);
        cart.addProduct("Mouse", 50.00);
        cart.addProduct("Monitor", 300.00);
        cart.addProduct("Keyboard", 100.00);

        System.out.println("Product Prices (HashMap): " + cart.getProductPrices());
        System.out.println("Cart Order (LinkedHashMap - Insertion Order): " + cart.getCartOrder());
        System.out.println("Items Sorted by Price (TreeMap): " + cart.getSortedByPrice());
    }
}
