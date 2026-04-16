package codesignal;

import java.util.Arrays;

// TODO: try again
//  nao consegui :(

public class AlmostIncreasingSequence {

    public static boolean almostIncreasingSequence(int[] sequence) {

        int count = 0;

        for(int i = 0; i< sequence.length-1; i++) {

            if(sequence[i] >= sequence[i+1]) {
                count++;
            }

            if(count > 1) {
                return false;
            }

            if(sequence[i] >= sequence[i+1] && i-1 > 0 && sequence[i-1] >= sequence[i+1]) {
                return false;
            }

        }

        return true;

    }

    public static void main(String[] args) {

        runTest(new int[]{1, 3, 2, 1}, false);
        runTest(new int[]{1, 3, 2}, true);
        runTest(new int[]{1, 2, 3, 4, 5}, true);
        runTest(new int[]{1, 2, 5, 3, 5}, true);
        runTest(new int[]{10, 1, 2, 3, 4, 5}, true);
        runTest(new int[]{1, 2, 3, 4, 3, 6}, true);
        runTest(new int[]{1, 2, 3, 4, 99, 5, 6}, true);
        runTest(new int[]{1, 1, 1, 2, 3}, false);
        runTest(new int[]{1, 2, 1, 2}, false);
        runTest(new int[]{3, 5, 67, 98, 3}, true);

        // edge cases
        runTest(new int[]{1}, true);
        runTest(new int[]{1, 2}, true);
        runTest(new int[]{2, 1}, true);
        runTest(new int[]{1, 1}, true);

    }

    private static void runTest(int[] input, boolean expected) {
        boolean result = almostIncreasingSequence(input);
        System.out.println(
                Arrays.toString(input) +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }




}

/*


count how many are strictly greater than the one on the right

1,3,2,1


 */