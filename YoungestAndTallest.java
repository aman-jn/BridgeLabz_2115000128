import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Amar's age: ");
        int amarAge = scanner.nextInt();
        System.out.print("Enter Akbar's age: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = scanner.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        int amarHeight = scanner.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        int akbarHeight = scanner.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        int anthonyHeight = scanner.nextInt();

        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        if (youngestAge == amarAge) {
            System.out.println("The youngest friend is Amar with age " + amarAge);
        } else if (youngestAge == akbarAge) {
            System.out.println("The youngest friend is Akbar with age " + akbarAge);
        } else {
            System.out.println("The youngest friend is Anthony with age " + anthonyAge);
        }

        int tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        if (tallestHeight == amarHeight) {
            System.out.println("The tallest friend is Amar with height " + amarHeight + " cm.");
        } else if (tallestHeight == akbarHeight) {
            System.out.println("The tallest friend is Akbar with height " + akbarHeight + " cm.");
        } else {
            System.out.println("The tallest friend is Anthony with height " + anthonyHeight + " cm.");
        }

        scanner.close();
    }
}
