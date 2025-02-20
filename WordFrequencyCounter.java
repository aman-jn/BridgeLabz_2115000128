import java.util.*;
import java.io.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> frequencyMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();
        return frequencyMap;
    }

    public static void main(String[] args) {
        String filePath = "input.txt";
        try {
            Map<String, Integer> frequencies = countWordFrequency(filePath);
            System.out.println("Word Frequencies: " + frequencies);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
