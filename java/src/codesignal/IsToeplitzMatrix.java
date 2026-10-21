package codesignal;

public class IsToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                
                if (matrix[i-1][j-1] != matrix[i][j]) {
                    return false;
                }
                
            }
        }
        
        return true;
    }
}
