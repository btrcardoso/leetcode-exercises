// https://leetcode.com/problems/largest-magic-square/
public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int largestSize = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {

                if (needsToBeChecked(i, j, grid, largestSize)) {
                    int largestOfPosition = largestMagicSquareOfPosition(i, j, grid, largestSize);

                    if (largestSize < largestOfPosition) {
                        largestSize = largestOfPosition;
                    }
                }

            }
        }


        return largestSize;
    }

    public boolean needsToBeChecked(int i, int j, int[][] grid, int largestSize) {
        boolean hasMoreRows = grid.length - i > largestSize;
        boolean hasMoreColumns = grid[i].length - j > largestSize;

        return hasMoreRows && hasMoreColumns;
    }

    public int largestMagicSquareOfPosition(int i, int j, int[][] grid, int largestSize) {

        int smallerDimension = grid.length > grid[i].length ? grid.length : grid[i].length;
        int largest = 0;

        for (int n = largestSize + 1; n <= smallerDimension; n++) {

            if (isAValidSquare(i, j, n, grid) && isAMagicSquare(i, j, n, grid) && n > largest) {
                largest = n;
            }

        }

        return largest;

    }

    public boolean isAValidSquare(int i, int j, int n, int[][] grid) {
        boolean hasEnoughRows = grid.length > i + n - 1 ;
        boolean hasEnoughColumns = grid[i].length > j + n - 1;

        return hasEnoughRows && hasEnoughColumns;
    }

    public boolean isAMagicSquare(int i, int j, int n, int[][] grid) {
        int diagonal1Sum = 0;
        int diagonal2Sum = 0;
        int sum = -1;

        for (int k = i; k < n + i; k++) {

            int rowsSum = 0;
            int columnsSum = 0;

            for (int l = j; l < n + j; l++) {

                rowsSum += grid[k][l];
                columnsSum += grid[l+i-j][k+j-i];
                if (k + j == l + i) diagonal1Sum += grid[k][l];
                if (k + l == n - 1 + i + j) diagonal2Sum += grid[k][l];

            }

            if (sum == -1) {
                sum = rowsSum;
            }

            if (rowsSum != sum || columnsSum != sum) {
                return false;
            }

        }

        if (diagonal1Sum != sum || diagonal2Sum != sum) {
            return false;
        }


        return true;
    }
}
