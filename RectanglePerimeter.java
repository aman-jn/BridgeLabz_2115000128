import java.util.Scanner;
class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the principal amount: ");
        int principal = scanner.nextInt();
        System.out.print("Enter the rate of interest: ");
        int rate = scanner.nextInt();
        System.out.print("Enter the time period: ");
        int time = scanner.nextInt();
        int simpleInterest = (principal * rate * time) / 100;
        System.out.println("The simple interest is: " + simpleInterest);
    }
}
