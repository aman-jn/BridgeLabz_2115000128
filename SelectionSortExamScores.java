import java.util.Scanner;

public class SelectionSortExamScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] examScores = new int[n];
        
        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            examScores[i] = scanner.nextInt();
        }
        
        selectionSort(examScores);
        
        System.out.println("Sorted exam scores in ascending order:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
        
        scanner.close();
    }
    
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}