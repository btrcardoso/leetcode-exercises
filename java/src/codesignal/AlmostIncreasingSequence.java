package codesignal;

import java.util.Arrays;

// TODO: redo
//https://www.youtube.com/watch?v=QbKbfsnAv2E

public class AlmostIncreasingSequence {

    public static boolean almostIncreasingSequence(int[] sequence) {
        int countError = 0;

        for (int i=1; i<sequence.length; i++) {

            // error: the previous is greater than the current
            if (sequence[i-1] >= sequence[i]) {
                countError++;

                if (countError > 1) return false;

                boolean skipCurrent = i+1 < sequence.length && sequence[i-1] >= sequence[i+1]; // take out the current
                boolean skipPrevious = i-2 >= 0 && sequence[i-2] >= sequence[i];               // take out the previous

                if (skipCurrent && skipPrevious) return false; // if I took both out and got not satisfied, then it is false
            }

        }

        return true;
    }

    /*

    1, 2, 3, 4, 3, 6


     */

    /*


    contar quantos elementos são picos i > i+1

    count = 1
            se achei o pico e
            i-1 >= i+1        -> false



    4 2 5 2 6


     */





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