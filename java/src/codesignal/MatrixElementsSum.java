package codesignal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MatrixElementsSum {
    public static int matrixElementsSum(int[][] matrix) {
        int sum = 0;

        Set<Integer> colsWithPhantom = new HashSet<>();

        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {

                if(matrix[i][j] == 0) {
                    colsWithPhantom.add(j);
                }

                if (!colsWithPhantom.contains(j)) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }


    /*

1, 1, 1, 0
0, 5, 0, 1
2, 3, 3, 3

 */


    public static void main(String[] args) {
        runTest(new int[][]{{0, 1, 1, 2}, {0, 5, 0, 0}, {2, 0, 3, 3}}, 9);
        runTest(new int[][]{{1, 1, 1, 0}, {0, 5, 0, 1}, {2, 3, 3, 3}}, 11);
        runTest(new int[][]{{1, 2, 3}, {4, 5, 6}}, 21);
        runTest(new int[][]{{1}, {2}, {3}}, 6);
        runTest(new int[][]{{0}}, 0);

        // edge cases
        runTest(new int[][]{{1, 0}, {2, 3}}, 3);
        runTest(new int[][]{{1, 2}, {0, 3}}, 6);
    }

    private static void runTest(int[][] input, int expected) {
        int result = matrixElementsSum(input);
        System.out.println(
                Arrays.deepToString(input) +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}
