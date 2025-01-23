import java.util.Scanner;
public class NaturalNumberSumComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        if (n >= 0) {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0, counter = 1;
            while (counter <= n) {
                loopSum += counter;
                counter++;
            }
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using while loop: " + loopSum);
            System.out.println("The results are " + (formulaSum == loopSum ? "correct and match." : "incorrect and do not match."));
        } else {
            System.out.println("The entered number is not a natural number.");
        }
        scanner.close();
    }
}
