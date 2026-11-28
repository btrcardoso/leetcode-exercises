package codesignal.graphAlgorithmsImplementation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindAllVerticesWithinAGIvenDistance {
    
public List<Integer> findVerticesWithinDistance(Map<Integer, List<Integer>> graph, int start, int distance) {
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> queueLevel = new ArrayDeque<>();
        
        queue.offer(start);
        queueLevel.offer(0);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            
            Integer curLevel = queueLevel.poll();
            if (curLevel > distance) {
                break;
            }
            
            Integer cur = queue.poll();
            result.add(cur);
            
            List<Integer> neighborhood = graph.get(cur);
            if (neighborhood != null) {
                for (Integer neighbor : neighborhood) {
                    if (!visited.contains(neighbor)) {
                        
                        visited.add(neighbor); 
                        queue.offer(neighbor);
                        queueLevel.offer(curLevel + 1);
                        
                    }
                    
                }
            }
            
            
        }
        
        return result;
    }
}
