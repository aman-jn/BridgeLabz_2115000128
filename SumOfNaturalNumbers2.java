import java.util.Scanner;

public class SumOfNaturalNumbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("The input is not a natural number. Please enter a positive integer.");
            scanner.close();
            return;
        }

        int sumUsingRecursion = findSumUsingRecursion(n);
        int sumUsingFormula = findSumUsingFormula(n);

        System.out.println("Sum of " + n + " natural numbers using recursion: " + sumUsingRecursion);
        System.out.println("Sum of " + n + " natural numbers using formula: " + sumUsingFormula);

        if (sumUsingRecursion == sumUsingFormula) {
            System.out.println("Both results are equal and correct.");
        } else {
            System.out.println("There is a discrepancy between the results.");
        }

        scanner.close();
    }

    public static int findSumUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + findSumUsingRecursion(n - 1);
    }

    public static int findSumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }
}
