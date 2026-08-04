package codesignal;

import java.util.Arrays;

public class Minesweeper {
    public static int[][] minesweeper(boolean[][] matrix) {
        int[][] minesweeper = new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                minesweeper[i][j] = countMines(matrix, i, j);
            }
        }

        return minesweeper;
    }

    public static int countMines(boolean[][] matrix, int l, int c) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int count = 0;

        for (int i=l-1; i<=l+1; i++) {
            for (int j=c-1; j<=c+1; j++) {

                if (i==l && j==c) continue;

                if (i < 0 || j < 0 || i >= rows || j >= columns) continue;

                if (matrix[i][j]) count++;

            }
        }

        return count;
    }




    public static void main(String[] args) {
        runTest(
                new boolean[][]{{true, false, false}, {false, true, false}, {false, false, false}},
                new int[][]{{1, 2, 1}, {2, 1, 1}, {1, 1, 1}}
        );
        runTest(
                new boolean[][]{{false, false, false}, {false, false, false}},
                new int[][]{{0, 0, 0}, {0, 0, 0}}
        );
        runTest(
                new boolean[][]{{true, true}, {true, true}},
                new int[][]{{3, 3}, {3, 3}}
        );
        runTest(
                new boolean[][]{{false, true, false}, {true, false, true}, {false, true, false}},
                new int[][]{{2, 2, 2}, {2, 4, 2}, {2, 2, 2}}
        );

        // edge cases
        runTest(new boolean[][]{{true}}, new int[][]{{0}});
        runTest(new boolean[][]{{false}}, new int[][]{{0}});
    }

    private static void runTest(boolean[][] input, int[][] expected) {
        int[][] result = minesweeper(input);
        System.out.println(
                Arrays.deepToString(input) +
                        " -> result: " + Arrays.deepToString(result) +
                        " | expected: " + Arrays.deepToString(expected) +
                        (Arrays.deepEquals(result, expected) ? " ✅" : " ❌")
        );
    }
}
