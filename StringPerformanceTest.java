package array;

public class StringPerformanceTest {
    public static void main(String[] args) {

        // Test StringBuffer
        StringBuffer sbf = new StringBuffer();
        long startTime1 = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            sbf.append("AIET");
        }

        long endTime1 = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime1 - startTime1) + " ns");

        // Test StringBuilder
        StringBuilder sbd = new StringBuilder();
        long startTime2 = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            sbd.append("AIET");
        }

        long endTime2 = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTime2 - startTime2) + " ns");
    }
}
