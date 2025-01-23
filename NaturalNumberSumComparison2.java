import java.util.Scanner;
public class NaturalNumberSumComparison2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        if (n >= 0) {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);
            System.out.println("The results are " + (formulaSum == loopSum ? "correct and match." : "incorrect and do not match."));
        } else {
            System.out.println("The entered number is not a natural number.");
        }
        scanner.close();
    }
}
