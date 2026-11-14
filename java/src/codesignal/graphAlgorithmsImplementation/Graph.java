package codesignal.graphAlgorithmsImplementation;

import java.util.*;

public class Graph {
    
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int i, int j) {
        graph.putIfAbsent(i, new ArrayList<>());
        graph.putIfAbsent(j, new ArrayList<>());
        graph.get(i).add(j);
        graph.get(j).add(i);
    }

    public List<Integer> bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        queue.add(v);

        while (queue.size() > 0) {

            Integer cur = queue.poll();

            if (!visited.contains(cur) && graph.containsKey(cur)) {

                visited.add(cur);
                result.add(cur);

                for (Integer neighbor : graph.get(cur)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
                
            }

        }

        return result;
    }

}