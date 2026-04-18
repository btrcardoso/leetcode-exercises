package codesignal;

import java.util.Arrays;

// o(m*n*9) = o(m*n)
//https://www.youtube.com/watch?v=kdUaM2XSo0E

public class BoxBlur {
    public static int[][] boxBlur(int[][] image) {
        int[][] blurred = new int[image.length - 2][image[0].length - 2];

        for(int i=0; i<image.length - 2;i++){
            for(int j=0; j<image[0].length - 2;j++){
                blurred[i][j] = getAvg(image, i, j);
            }
        }

        return blurred;
    }

    public static int getAvg(int[][] image, int l, int c) {
        int sum = 0;

        for(int i=l; i<l+3;i++){
            for(int j=c; j<c+3;j++){
                sum+=image[i][j];
            }
        }

        return sum / 9;
    }




    /*

{36, 0, 18, 9},
{27, 54, 9, 0},
{81, 63, 72, 45},
{81, 63, 72, 45},

     */











    public static void main(String[] args) {
        runTest(
                new int[][]{{36, 0, 18, 9}, {27, 54, 9, 0}, {81, 63, 72, 45}},
                new int[][]{{40, 30}}
        );
        runTest(
                new int[][]{{1, 1, 1}, {1, 7, 1}, {1, 1, 1}},
                new int[][]{{1}}
        );
        runTest(
                new int[][]{{0, 0, 0}, {0, 9, 0}, {0, 0, 0}},
                new int[][]{{1}}
        );
        runTest(
                new int[][]{{9, 9, 9}, {9, 9, 9}, {9, 9, 9}},
                new int[][]{{9}}
        );

        // edge cases
        runTest(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                new int[][]{{5}}
        );
    }

    private static void runTest(int[][] input, int[][] expected) {
        int[][] result = boxBlur(input);
        System.out.println(
                Arrays.deepToString(input) +
                        " -> result: " + Arrays.deepToString(result) +
                        " | expected: " + Arrays.deepToString(expected) +
                        (Arrays.deepEquals(result, expected) ? " ✅" : " ❌")
        );
    }
}
