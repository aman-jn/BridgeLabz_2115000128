import java.util.Random;

public class FootballTeamStats {

    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    public static double findMeanHeight(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    public static int findShortestHeight(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        return shortest;
    }

    public static int findTallestHeight(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];
        Random random = new Random();

        System.out.println("Heights of players (in cms):");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + random.nextInt(101);
            System.out.print(heights[i] + " ");
        }

        System.out.println("\n\nResults:");
        System.out.println("Shortest height: " + findShortestHeight(heights) + " cms");
        System.out.println("Tallest height: " + findTallestHeight(heights) + " cms");
        System.out.printf("Mean height: %.2f cms%n", findMeanHeight(heights));
    }
}
