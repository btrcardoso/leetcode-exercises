public class LargestSquareInAField {

    int n;
    int m;

    // I Ddon't know if it works. Test later

    public int largestSquare(int[][] matrix) {

        int max = 0;
        n = matrix.length;
        m = matrix[0].length;

        int[][] memo = new int[n][m];

        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                max = Math.max(largest(i, j, matrix, memo), max);
            }
        }

        return max;
    }

    public int largest(int i, int j, int[][] matrix, int[][] memo) {

        if (matrix[i][j] == 0) {
            return 0;
        }

        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        int diagonalMax = 0;
        if (i + 1 < n && j + 1 < m) {
            diagonalMax = largest(i + 1, j + 1, matrix, memo);
        }

        int maxHorizontal = 0;
        for (int k = j + 1; k <= j + diagonalMax && k < m; k++) {
            if (matrix[i][k] != 1) {
                break;
            }
            maxHorizontal++;
        }

        int maxVertical = 0;
        for (int k = i + 1; k <= i + diagonalMax && k < n; k++) {
            if (matrix[k][j] != 1) {
                break;
            }
            maxVertical++;
        }

        int result = Math.min(maxVertical, maxHorizontal) + 1;

        memo[i][j] = result;

        return result;

    }

}
