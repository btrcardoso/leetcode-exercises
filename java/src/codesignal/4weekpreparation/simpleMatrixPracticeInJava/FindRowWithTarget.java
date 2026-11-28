package codesignal.simpleMatrixPracticeInJava;

public class FindRowWithTarget {

/*
https://codesignal.com/learn/course/479/unit/1/practice/4

You are given a matrix of integers where every row and column are sorted in ascending order. Your task is to find the row that contains a specific target value. If the number doesn't exist in the given matrix, return None.

It is guaranteed that target exists in the given matrix.

The expected time complexity is $O(n + m)$, where $n$ is the number of rows and $m$ is the number of columns.

*/

    public static Integer findRowWithTarget(int[][] matrix, int target) {
        
        int i = 0, j = matrix[0].length - 1;
        
        
        while (i < matrix.length) {
            
            if (j == -1) {
                return null;
                
            } else if (matrix[i][j] == target) {
                return i;
                
            } else if (matrix[i][j] > target) {
                j--;
                
            } else {
                i++;
            }
            
            
        }
    
        
        return null;
    }
}
