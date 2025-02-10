import java.util.*;
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity + ", Total: " + calculateTotalPrice());
    }
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount: 10% on Veg Items";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 1.2;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * ADDITIONAL_CHARGE;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount: 5% on Non-Veg Items";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Salad", 5.0, 2));
        order.add(new NonVegItem("Chicken Burger", 8.0, 1));

        for (FoodItem item : order) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                System.out.println(((Discountable) item).getDiscountDetails());
                System.out.println("Discounted Price: " + (item.calculateTotalPrice() - ((Discountable) item).applyDiscount()));
            }
            System.out.println("----------------------");
        }
    }
}
