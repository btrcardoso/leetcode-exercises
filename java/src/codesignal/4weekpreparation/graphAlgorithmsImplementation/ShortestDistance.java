package codesignal.graphAlgorithmsImplementation;

/*

You are provided with a representation of a network of cities and roads between them. Each city can be identified by a unique string 
identifier, and for each city you are given a set of cities it is connected to by a road.

Your task is to create a function shortestDistance(Map<String, Set<String>> roads, String start, String destination) in Java that
 extracts the shortest distance from start to destination using the graph traversal algorithm we discussed in the lesson, 
 the Breadth-First Search (BFS). If there are no roads leading to the destination, your function should return null.

*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestDistance {
        public static Integer shortestDistance(Map<String, Set<String>> roads, String start, String destination) {
        
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));
        
        while (queue.size() > 0) {
            
            Pair node = queue.poll();
            
            if (node.city.equals(destination)) {
                return node.distance;
            }
            
            if (!visited.contains(node.city)) {
                
                visited.add(node.city);
                
                for (String neighbor : roads.get(node.city)) {
                    
                    if (!visited.contains(neighbor)) {
                        queue.add(new Pair(neighbor, node.distance + 1));
                    }
                    
                }
                
            }
            
        }
        
        return null;
    }

    private static class Pair {
        String city;
        int distance;
        
        Pair(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }
}
