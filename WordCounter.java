import java.io.*;

public class WordCounter {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String targetWord = "Java";
        int wordCount = countWordOccurrences(filePath, targetWord);

        System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
    }

    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.equals(targetWord.toLowerCase())) {
                        count++;
                    }
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }
}
