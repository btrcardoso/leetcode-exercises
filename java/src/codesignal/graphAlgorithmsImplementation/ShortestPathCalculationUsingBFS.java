package codesignal.graphAlgorithmsImplementation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestPathCalculationUsingBFS {

    public static void main() {
        System.out.println(shortestRoute(11,3 , Arrays.asList(4,7,9)));
    }

    public static int shortestRoute(int distance, int strideLength, List<Integer> obstacles) {

        Queue<Integer> queue = new ArrayDeque<>(); 
        Set<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);
        int level = 0;

        while (queue.size() > 0) {

            int qtLevel = queue.size();
            for (int i = 0; i < qtLevel; i++) {

                Integer cur = queue.poll();

                if (cur == distance - 1) {
                    return level;
                }

                for (int j = 1; j <= strideLength && cur + j < distance; j++) {

                    if (!visited.contains(cur + j) && !obstacles.contains(cur + j)) {
                        queue.add(cur + j);
                        visited.add(cur + j);
                    }

                }
            }

            level++;

        }

        return -1;
        
       
    }
}


/*

Queue<Integer> queue = new ArrayDeque<>(); 
Set<Integer> visited = new HashSet<>();


0  1
   2
   3  




*/
