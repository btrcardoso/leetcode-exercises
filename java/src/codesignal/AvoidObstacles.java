package codesignal;

import java.util.Arrays;

public class AvoidObstacles {
    public static int avoidObstacles(int[] inputArray) {

        int jump = 2;

        for(int i=0; i<inputArray.length; i++) {

            while (inputArray[i] % jump == 0) {
                jump++;
            }

        }

        return jump;
    }



    /*
find the first number that is not divisible by the obstacle

    5,3,6,7,9

    5%1 = 0
    5%2 = 1 -> 2

    3%2 = 1 -> 2

    6%2 = 0
    6%3 = 0
    6%4 = 1 -> 4

    7%4 = 1 -> 4

    9%4 = 1 -> 4


     */


















    public static void main(String[] args) {
        runTest(new int[]{5, 3, 6, 7, 9}, 4);
        runTest(new int[]{2, 3}, 4);
        runTest(new int[]{1, 4}, 3);
        runTest(new int[]{6, 5, 3}, 4);
        runTest(new int[]{1, 2, 3}, 4);

        // edge cases
        runTest(new int[]{2}, 3);
        runTest(new int[]{10}, 3);
    }

    private static void runTest(int[] input, int expected) {
        int result = avoidObstacles(input.clone());
        System.out.println(
                Arrays.toString(input) +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}
