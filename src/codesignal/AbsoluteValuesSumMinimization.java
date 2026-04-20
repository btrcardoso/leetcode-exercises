package codesignal;
import java.util.*;

public class AbsoluteValuesSumMinimization {

    public static int abs(int x) {
        return x<0 ? x*(-1) : x;
    }

    public static int absoluteValuesSumMinimization(int[] a) {

        int lessResult = Integer.MAX_VALUE;
        int response = 0;

        for (int x=0; x<a.length; x++) {

            int sum = 0;

            for (int j=0; j<a.length; j++) {

                sum += abs(a[j] - a[x]);
                
            }

            if(sum < lessResult) {
                lessResult = sum;
                response = a[x];
            }

        }

        return response;

    }

    public static void main(String[] args) {
        runTest(new int[]{2, 4, 7}, 4);
        runTest(new int[]{2, 3}, 2);
        runTest(new int[]{1, 1, 3, 4}, 1);

        // edge cases
        runTest(new int[]{1}, 1);
        runTest(new int[]{-10, -5, -3, -1}, -5);
    }

    private static void runTest(int[] input, int expected) {
        int result = absoluteValuesSumMinimization(input);
        System.out.println(
                Arrays.toString(input) +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}