import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        long sbStart = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long sbEnd = System.nanoTime();
        System.out.println("StringBuilder time: " + (sbEnd - sbStart) / 1_000_000.0 + " ms");

        long sbfStart = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long sbfEnd = System.nanoTime();
        System.out.println("StringBuffer time: " + (sbfEnd - sbfStart) / 1_000_000.0 + " ms");

        String filePath = "largefile.txt";

        long frStart = System.nanoTime();
        int wordCountFileReader = countWordsUsingFileReader(filePath);
        long frEnd = System.nanoTime();
        System.out.println("FileReader word count: " + wordCountFileReader);
        System.out.println("FileReader time: " + (frEnd - frStart) / 1_000_000.0 + " ms");

        long isrStart = System.nanoTime();
        int wordCountInputStreamReader = countWordsUsingInputStreamReader(filePath);
        long isrEnd = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCountInputStreamReader);
        System.out.println("InputStreamReader time: " + (isrEnd - isrStart) / 1_000_000.0 + " ms");
    }

    public static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    public static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}
