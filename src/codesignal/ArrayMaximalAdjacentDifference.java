package simulations.pt3;
import java.util.*;

public class ArrayMaximalAdjacentDifference {

    public static int arrayMaximalAdjacentDifference(int[] inputArray) {

        int max = 0;

        for(int i=0; i<inputArray.length-1; i++) {

            int diff = inputArray[i] - inputArray[i+1];
            int absDiff = diff < 0 ? diff*(-1) : diff;

            if(absDiff > max) {
                max = absDiff;
            }

        }

        return max;
    }


    /*
    
    diferença absoluta maxima
    
    */
    public static void main(String[] args) {
        runTest(new int[]{2, 4, 1, 0}, 3);
        runTest(new int[]{1, 1, 1, 1}, 0);
        runTest(new int[]{-1, 4, 10, 3, -2}, 7);

        // edge cases
        runTest(new int[]{5, 10}, 5);
    }

    private static void runTest(int[] input, int expected) {
        int result = arrayMaximalAdjacentDifference(input);
        System.out.println(
                Arrays.toString(input) +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}