import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter the day (1-31): ");
        int day = scanner.nextInt();

        boolean isSpring = isSpringSeason(month, day);

        if (isSpring) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }

        scanner.close();
    }

    public static boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20 && day <= 31) return true;
        if (month == 4 && day >= 1 && day <= 30) return true;
        if (month == 5 && day >= 1 && day <= 31) return true;
        if (month == 6 && day >= 1 && day <= 20) return true;
        return false;
    }
}
