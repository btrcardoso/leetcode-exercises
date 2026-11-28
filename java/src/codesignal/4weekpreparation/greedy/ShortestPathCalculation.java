package codesignal.greedy;

import java.util.Arrays;
import java.util.List;

public class ShortestPathCalculation {

    public static void main() {
        System.out.println(shortestRoute(11,3 , Arrays.asList(4,7,9)));
    }

    public static int shortestRoute(int distance, int strideLength, List<Integer> obstacles) {
        
        int strides = 0;
        int pos = 0;
        
        while (pos < distance - 1 && strideLength > 0) {
            
            int jumps = strideLength;
            while (obstacles.contains(pos + jumps) || pos + jumps >= distance) {
                jumps--;
                if (jumps == 0) {
                    return -1;
                }
            }         
            
            pos += jumps;
            strides++;
            
        }
        
        return strides;
    }
}
