package codesignal.advancedGraphAlgorithms;

import java.util.*;

public class Dijkstra {

    /*
    Retorna um Map com a distancia de todos os nós ao nó start
    dijkstra(graph, "A")
    Output: {A=0, B=1, C=3, D=4}
    */
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        minHeap.add(new Node(start, 0));

        Map<String, Integer> result = new HashMap<>();
        result.put(start, 0);


        while (minHeap.size() > 0) {

            Node node = minHeap.poll();
            String nodeName = node.name;
            int nodeDist = node.distance;

            if (nodeDist > result.getOrDefault(nodeName, Integer.MAX_VALUE)){
                continue;
            }

            Map<String, Integer> neighborhood = graph.getOrDefault(nodeName, new HashMap<>());

            for (Map.Entry<String, Integer> neighbor : neighborhood.entrySet()) {
                String neighborName = neighbor.getKey();
                int neighborWeight = neighbor.getValue();

                int newDist = nodeDist + neighborWeight;
                int curDist = result.getOrDefault(neighborName, Integer.MAX_VALUE);

                if (newDist < curDist) {
                    result.put(neighborName, newDist);
                    minHeap.add(new Node(neighborName, newDist));
                }
            }

        }


        return result;
    }


    static class Node {
        String name;
        int distance;

        Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }
    
}
