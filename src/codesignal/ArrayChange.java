package codesignal;

import java.util.Arrays;

public class ArrayChange {
    public static int arrayChange(int[] inputArray) {
        int count = 0;

        for(int i=1; i<inputArray.length;i++){

            if (inputArray[i-1] >= inputArray[i]) {
                int sum = inputArray[i-1] - inputArray[i] + 1;
                inputArray[i] += sum;
                count += sum;
            }

        }

        return count;
    }

    public static void main(String[] args) {

        runTest(new int[]{1, 1, 1}, 3);
        runTest(new int[]{1, 5, 2, 4, 1}, 14);
        runTest(new int[]{8}, 0);
        runTest(new int[]{-1, -1, -1}, 3);
        runTest(new int[]{1, 2, 3, 4, 5}, 0);
        runTest(new int[]{1, 2, 2}, 1);
        runTest(new int[]{2, 1, 10, 1}, 12);
        runTest(new int[]{0, 0, 0, 0}, 6);

        // edge cases
        runTest(new int[]{1000, 1000, 1000}, 3);
        runTest(new int[]{1}, 0);
        runTest(new int[]{5, 4, 3, 2, 1}, 20);

    }

    private static void runTest(int[] input, int expected) {
        int result = arrayChange(input.clone()); // clone pra não mutar original
        System.out.println(
                Arrays.toString(input) +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}
