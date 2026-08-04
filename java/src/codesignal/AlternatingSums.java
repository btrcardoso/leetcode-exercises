package codesignal;

import java.util.Arrays;

public class AlternatingSums {

    public static int[] alternatingSums(int[] queue) {

        int[] teams = new int[] {0,0};

        for (int i=0; i<queue.length; i++){

            if (i%2 == 0) {
                teams[0] += queue[i];
            } else {
                teams[1] += queue[i];
            }

        }

        return teams;
    }

    public static void main(String[] args) {

        runTest(new int[]{50, 60, 60, 45, 70}, new int[]{180, 105});
        runTest(new int[]{100, 50}, new int[]{100, 50});
        runTest(new int[]{1, 2, 3, 4, 5}, new int[]{9, 6});
        runTest(new int[]{10, 10, 10, 10}, new int[]{20, 20});
        runTest(new int[]{5, 3, 1}, new int[]{6, 3});

        // edge cases
        runTest(new int[]{1}, new int[]{1, 0});
        runTest(new int[]{7, 3}, new int[]{7, 3});

    }

    private static void runTest(int[] input, int[] expected) {
        int[] result = alternatingSums(input.clone());
        System.out.println(
                Arrays.toString(input) +
                        " -> result: " + Arrays.toString(result) +
                        " | expected: " + Arrays.toString(expected) +
                        (Arrays.equals(result, expected) ? " ✅" : " ❌")
        );
    }
}
