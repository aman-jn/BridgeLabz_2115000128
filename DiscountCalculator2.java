import java.util.Scanner;
public class DiscountCalculator2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the fee amount: ");
        double fee = sc.nextDouble();
        System.out.print("Enter the discount percentage: ");
        double discountPercent = sc.nextDouble();
        double discount = (fee * discountPercent) / 100.0;
        double finalFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
        sc.close();
    }
}