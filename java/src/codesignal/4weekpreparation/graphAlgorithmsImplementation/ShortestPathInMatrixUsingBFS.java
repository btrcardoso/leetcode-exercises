package codesignal.graphAlgorithmsImplementation;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInMatrixUsingBFS {
    public static int bfsMatrix(int[][] mat, int[] start, int[] end) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<String> queue = new ArrayDeque<>();
        queue.add(encode(start));
        
        int level = 0;
        
        int[][] directions = new int[][]{
            {-1, 0}, // up
            { 1, 0}, // down
            { 0,-1}, // left
            { 0, 1}  // right
        };
        
        while (queue.size() > 0) {                   // bfs algorithm
             
            int levelQt = queue.size();              // level by level
            
            for (int k = 0; k < levelQt; k++) {
                
                String key = queue.poll();
                if (key.equals(encode(end))) {      // if current is the end, the level is the distance from start to the end
                    return level;
                }
                
                int[] cur = decode(key);
                int i = cur[0];
                int j = cur[1];
                
                for (int[] direction : directions) {  // add neighbors
                    int row = i + direction[0];
                    int col = j + direction[1];
                    
                    if (0 <= row && row < m && 
                        0 <= col && col < n && 
                        mat[row][col] == 1) {         // only valid neighbors
                    
                        queue.add(encode(row, col));
                        mat[row][col] = 0;            // mark as unreacheable         
                    } 
                }                
                
            }            
            
            level ++;
        }
        
        
        return 0;
    }
    
    private static String encode(int i, int j){
        return i + "_" + j;
    }
    
    private static String encode(int[] pos){
        return pos[0] + "_" + pos[1];
    }
    
    private static int[] decode(String decoded){
        String[] str = decoded.split("_");
        
        int[] res = new int[2];
        
        res[0] = Integer.parseInt(str[0]);
        res[1] = Integer.parseInt(str[1]);
        
        return res;
    }
}
