import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {

    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3];

        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 50 + rand.nextInt(50);
            scores[i][1] = 50 + rand.nextInt(50);
            scores[i][2] = 50 + rand.nextInt(50);
        }

        return scores;
    }

    public static double[][] calculateResults(int[][] scores, int numStudents) {
        double[][] results = new double[numStudents][4];

        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return results;
    }

    public static void displayScoreCard(int[][] scores, double[][] results, int numStudents) {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Student", "Physics", "Chemistry", "Math", "Total",
                "Average", "Percentage");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10d%-10d%-10d%-10d%-10.2f%-10.2f%-10.2f\n", i + 1, scores[i][0], scores[i][1],
                    scores[i][2], results[i][0], results[i][1], results[i][2]);
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[][] scores = generateScores(numStudents);
        double[][] results = calculateResults(scores, numStudents);
        displayScoreCard(scores, results, numStudents);
        scanner.close();
    }
}
