import java.util.Scanner;
public class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number > 1) {
            boolean isPrime = true;

            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("The number " + number + " is a prime number.");
            } else {
                System.out.println("The number " + number + " is not a prime number.");
            }
        } else {
            System.out.println("Prime numbers are greater than 1.");
        }
        scanner.close();
    }
}
