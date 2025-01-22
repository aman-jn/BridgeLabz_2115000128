public class AverageMarkCalculator {
    public static void main(String[] args) {
        int mathsMark = 94;
        int physicsMark = 95;
        int chemistryMark = 96;
        int totalMarks = mathsMark + physicsMark + chemistryMark;
        double averageMark = totalMarks / 3.0;
        System.out.println("Sam's average mark in PCM is " + averageMark);
    }
}