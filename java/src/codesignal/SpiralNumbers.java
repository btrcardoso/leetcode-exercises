package codesignal;

import java.util.*;

// https://www.youtube.com/watch?v=-tgIgH-ZY2U

public class SpiralNumbers {

    public static int[][] spiralNumbers(int n) {

        int[][] matrix = new int[n][n];
        int count=1, c=0, l=0, times=0;

        while(count < n*n) {

            while (c < n-1-times) {
                matrix[l][c] = count++;
                c++;
            }

            while (l < n-1-times) {
                matrix[l][c] = count++;
                l++;
            }

            while (c > times) {
                matrix[l][c] = count++;
                c--;
            }

            while (l > times) {
                matrix[l][c] = count++;
                l--;
            }

            times++;
            l++;
            c++;

        }

        if (n%2 == 1) matrix[n/2][n/2] = count;

        return matrix;
     
    }


    /*
    
    
{1, 2, 3, 4},
{12, 13, 14, 5},
{11, 16, 15, 6},
{10, 9, 8, 7}



1,2,3,4

    */

    public static void main(String[] args) {
        runTest(3, new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        });

        runTest(4, new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        });

        runTest(5, new int[][]{
                { 1, 2, 3, 4, 5},
                {16,17,18,19, 6},
                {15,24,25,20, 7},
                {14,23,22,21, 8},
                {13,12,11,10, 9},
        });

        // edge case
        runTest(1, new int[][]{{1}});
    }

    private static void runTest(int input, int[][] expected) {
        int[][] result = spiralNumbers(input);
        System.out.println(
                "n = " + input +
                        " -> result: " + Arrays.deepToString(result) +
                        " | expected: " + Arrays.deepToString(expected) +
                        (Arrays.deepEquals(result, expected) ? " ✅" : " ❌")
        );
    }
}
