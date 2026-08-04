package codesignal;
//https://www.youtube.com/watch?v=yEf7fRbi7pg
import java.util.*;
public class ArrayReplace {
    public static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {

        for (int i=0; i<inputArray.length; i++) {
            if(inputArray[i] == elemToReplace) {
                inputArray[i] = substitutionElem;
            }

        }

        return inputArray;
    }

    public static void main(String[] args) {
        runTest(new int[]{1, 2, 1}, 1, 3, new int[]{3, 2, 3});
        runTest(new int[]{1, 2, 3, 4, 5}, 3, 0, new int[]{1, 2, 0, 4, 5});
        runTest(new int[]{1, 1, 1}, 1, 100, new int[]{100, 100, 100});
        runTest(new int[]{1, 2, 3}, 4, 0, new int[]{1, 2, 3});
        runTest(new int[]{0, 1, 0, 2, 0}, 0, 9, new int[]{9, 1, 9, 2, 9});

        // edge cases
        runTest(new int[]{5}, 5, 1, new int[]{1});
        runTest(new int[]{5}, 3, 1, new int[]{5});
    }

    private static void runTest(int[] input, int elemToReplace, int substitutionElem, int[] expected) {
        int[] result = arrayReplace(input.clone(), elemToReplace, substitutionElem);
        System.out.println(
                Arrays.toString(input) + " replace " + elemToReplace + " with " + substitutionElem +
                        " -> result: " + Arrays.toString(result) +
                        " | expected: " + Arrays.toString(expected) +
                        (Arrays.equals(result, expected) ? " ✅" : " ❌")
        );
    }
}