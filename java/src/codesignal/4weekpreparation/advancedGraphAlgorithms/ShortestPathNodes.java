package codesignal.advancedGraphAlgorithms;

/*
https://codesignal.com/learn/course/481/unit/3/practice/4

Given the flight map of a city, represented as a HashMap, where the key represents the name of the airport (as a String) and the corresponding value is another HashMap. In the second HashMap, the key represents the name of an airport directly reachable from the first airport, and the corresponding value represents the air distance (in km) between these two airports. Implement Dijkstra’s Algorithm to find the air distance of the shortest path between any two given airports. The function should return the corresponding distance. It is guaranteed the path from start to end always exists.

For instance:

Java
Copy to clipboard
Map<String, Map<String, Integer>> graph = new HashMap<String, Map<String, Integer>>() {{
    put("JFK", new HashMap<String, Integer>() {{
        put("LAX", 2500);
        put("MIA", 2000);
        put("ORD", 1200);
    }});
    put("LAX", new HashMap<String, Integer>() {{
        put("SEA", 2000);
        put("ORD", 3000);
    }});
    put("MIA", new HashMap<String, Integer>() {{
        put("ORD", 1500);
        put("ATL", 2000);
        put("DFW", 1800);
    }});
    put("ORD", new HashMap<String, Integer>() {{
        put("SEA", 2800);
    }});
    put("SEA", new HashMap<String, Integer>());
    put("ATL", new HashMap<String, Integer>() {{
        put("DFW", 1500);
    }});
    put("DFW", new HashMap<String, Integer>());
}};

*/

import java.util.*;

public class ShortestPathNodes {    
    static class Node {
        String name;
        int dist = Integer.MAX_VALUE;
        Node previous;
        
        Node (String name){
            this.name = name;
        }
        
        Node (String name, int distance){
            this.name = name;
            this.dist = distance;
        }
    }
    
    
    public static int shortestPath(Map<String, Map<String, Integer>> graph, String start, String end) {
        
        Map<String, Node> distances = new HashMap<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Node> toVisit = new PriorityQueue<>(Comparator.comparingInt(node -> node.dist));
        
        Node nodeParent = new Node(start, 0);
        toVisit.offer(nodeParent);
        distances.put(start, nodeParent);
        
        while (toVisit.size() > 0) {
            
            nodeParent = toVisit.poll();
            String parentName = nodeParent.name;
            int parentDist = nodeParent.dist;
            
            if (!visited.add(parentName)) {
                continue;
            }
            
            Map<String, Integer> children = graph.get(parentName);
            for (Map.Entry<String, Integer> child : children.entrySet()) {
                
                String childName = child.getKey();
                int childDist = child.getValue();
                
                Node nodeChild = distances.getOrDefault(childName, new Node(childName));
                
                if (nodeChild.dist > parentDist + childDist) {
                    nodeChild.dist = parentDist + childDist;
                    nodeChild.previous = nodeParent;
                    
                    toVisit.offer(nodeChild);
                }
                
                distances.put(childName, nodeChild);
                
            }
            
        }
        
        
        return distances.get(end).dist;
    }
}


/*

dijkstra - encontrar a menor distancia do ponto start até todos os pontos

Map<String, Node> distances = new HashMap<()>

Set<String> visited = new HashSet<>();
Queue<Node> toVisit = new ArrayDeque<>();




A -> C
|    |
v    v
B    D
\    /
 v  v
   E




*/