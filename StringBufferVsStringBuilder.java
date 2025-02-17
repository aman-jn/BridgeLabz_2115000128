public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        startTime = System.nanoTime();
        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbl.append(text);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + stringBufferTime / 1_000_000.0 + " ms");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime / 1_000_000.0 + " ms");
    }
}
