import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/magic-squares-in-grid/description/
public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        int n=3;
        int total=15;

        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (theSizeIsCompatible(i, j, n, grid) && isAMagicSquare(i, j, n, total, grid)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean theSizeIsCompatible(int i, int j, int n, int[][] grid){
        boolean hasEnoughRows = grid.length - i >= n;
        boolean hasEnoughColumns = grid[i].length - j >= n;

        return hasEnoughRows && hasEnoughColumns;
    }

    public boolean isAMagicSquare(int i, int j, int n, int total, int[][] grid) {
        int diagonal1Sum = 0;
        int diagonal2Sum = 0;
        Set<Integer> numbers = new HashSet<>();

        for (int k=i; k<n+i; k++) {
            int rowSum = 0;
            int columnSum = 0;

            for (int l=j; l<n+j; l++) {
                // validate range 1-9
                if (grid[k][l] < 1 || grid[k][l] > n*n){
                    return false;
                }

                // guarantee non-repeated numbers in a square
                if (numbers.contains(grid[k][l])) {
                    return false;
                }
                numbers.add(grid[k][l]);

                rowSum += grid[k][l];
                columnSum += grid[l+i-j][k+j-i];
                if (k-i == l-j) diagonal1Sum += grid[k][l];
                if (k+l == n-1+i+j) diagonal2Sum += grid[k][l];
            }

            if (rowSum != total || columnSum != total) {
                return false;
            }

        }

        if (diagonal1Sum != total || diagonal2Sum != total) {
            return false;
        }

        return true;

    }

    public void tests(){
        int[][] grid =
                {{4,3,8,4},{9,5,1,9},{2,7,6,2}}
                // {{5,5,5},{5,5,5},{5,5,5}}
                // {{1,1,1},{1,1,1},{1,1,1}}
                // {{9,9,5,1,9,5,5,7,2,5},{9,1,8,3,4,6,7,2,8,9},{4,1,1,5,9,1,5,9,6,4},{5,5,6,7,2,8,3,4,0,6},{1,9,1,8,3,1,4,2,9,4},{2,8,6,4,2,7,3,2,7,6},{9,2,5,0,7,8,2,9,5,1},{2,1,4,4,7,6,2,4,3,8},{1,2,5,3,0,5,10,8,5,2},{6,9,6,8,8,4,3,6,0,9}}
                // {{7,0,5},{2,4,6},{3,8,1}}
                // {{4, 3, 8, 4},{9, 5, 1, 9},{2, 7, 6, 2},{4, 3, 8, 1},{1, 6, 7, 5}}
                // { {4, 3, 8, 4, 3},{9, 5, 1, 9, 5}, {2, 7, 6, 2, 7},{4, 3, 8, 4, 3},{9, 5, 1, 9, 5},{2, 7, 6, 2, 7}}
                // {{4, 3, 8, 1, 6, 7},{9, 5, 1, 7, 8, 9},{2, 7, 6, 4, 9, 1},{8, 1, 6, 4, 3, 8},{3, 7, 9, 2, 8, 1},{4, 3, 8, 1, 6, 7},{9, 5, 1, 7, 8, 9},{2, 7, 6, 4, 9, 1},{8, 1, 6, 4, 3, 8},{1, 6, 7, 8, 9, 2}}
                // {{4, 3, 8, 4, 3, 8},{9, 5, 1, 9, 5, 1},{2, 7, 6, 2, 7, 6},{4, 3, 8, 4, 3, 8},{9, 5, 1, 9, 5, 1},{2, 7, 6, 2, 7, 6},{4, 3, 8, 4, 3, 8},{9, 5, 1, 9, 5, 1},{2, 7, 6, 2, 7, 6}}
                // {{4, 3, 8, 4, 3, 8, 4, 3, 8},{9, 5, 1, 9, 5, 1, 9, 5, 1},{2, 7, 6, 2, 7, 6, 2, 7, 6},{8, 1, 6, 4, 3, 8, 4, 3, 8},{3, 7, 9, 2, 8, 1, 9, 5, 1},{4, 3, 8, 1, 6, 7, 2, 7, 6},{9, 5, 1, 7, 8, 9, 8, 1, 6},{2, 7, 6, 4, 9, 1, 3, 7, 9},{8, 1, 6, 4, 3, 8, 4, 3, 8},{3, 7, 9, 2, 8, 1, 9, 5, 1}}
                ;


        System.out.println(numMagicSquaresInside(grid));
    }
}
