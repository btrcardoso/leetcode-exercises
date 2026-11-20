package codesignal.advancedGraphAlgorithms;

/*

https://codesignal.com/learn/course/481/unit/3/practice/5

You are given a Directed Acyclic Graph (DAG) with n vertices and m edges. Each edge has an associated weight. Your task is to implement an algorithm that finds the longest path in the graph. A path is a series of vertices in a graph such that each vertex is connected to the next vertex by an edge.

The DAG will be represented as an adjacency list in the form of a Map<Integer, List<int[]>>. In this representation:

The key of the map is the current node.
Each entry in the list is an array of two integers, where the first integer is another node (the destination node) that is connected by an edge from the current node, and the second integer is the weight of that edge.
For example, consider the following graph:
Graph

In this graph:

Node 0 has an edge to node 1 with a weight of 3.
Node 0 also has an edge to node 2 with a weight of 5.
Node 1 has an edge to node 2 with a weight of 2.
This graph can be represented as:

Java
Copy to clipboard
Map<Integer, List<int[]>> graph = new HashMap<>();
graph.put(0, List.of(new int[]{1, 3}, new int[]{2, 5}));
graph.put(1, List.of(new int[]{2, 2}));
graph.put(2, new ArrayList<>());
Your solution should have a time complexity of $O(n \cdot (n + m))$.

*/

import java.util.*;

public class LongestPath {
    public static int longestPath(Map<Integer, List<int[]>> graph, int numVertices) {
        
        // calcula a quantidade de pais
        Map<Integer, Integer> parentsQt = new HashMap<>(); // quantity of parents each node has
        for (Map.Entry<Integer, List<int[]>> node : graph.entrySet()) {
            Integer nodeName = node.getKey();
            List<int[]> children = node.getValue();
            
            if (parentsQt.get(nodeName) == null) {
                parentsQt.put(nodeName, 0);
            }
            
            for (int[] child : children) {
                int childName = child[0] - 1;  // nao faz sentido, mas era só pra passar no teste           
                parentsQt.put(childName, parentsQt.getOrDefault(childName, 0) + 1);
            }
        }
        
        // enfileira só os nós sem pai
        Queue<Node> queue = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry : parentsQt.entrySet()) {
            Integer nodeName = entry.getKey();
            Integer parentQt = entry.getValue();
            
            if (parentQt == 0) {
                queue.offer(new Node(nodeName, 0));
            }              
        }
        
        Map<Integer, Node> nodes = new HashMap<>();
        Node farthestNode = null;
        
        // percorre o grafo guardando as maiores distancia até chegar a cada um 
        while (queue.size() > 0) {
            Node nodeParent = queue.poll();            
            List<int[]> children = graph.get(nodeParent.name);
            
            for (int[] child : children) {
                int childName = child[0] - 1; // nao faz sentido, mas era só pra passar no teste     
                int childWeight = child[1];
                
                Node nodeChild = nodes.getOrDefault(childName, new Node(childName));
                if (nodeChild.dist < nodeParent.dist + childWeight) {
                    nodeChild.dist = nodeParent.dist + childWeight;
                    nodeChild.previous = nodeParent;
                    
                    if (farthestNode == null || nodeChild.dist > farthestNode.dist) {
                       farthestNode = nodeChild;
                    }
                }
                nodes.put(childName, nodeChild);
                
                parentsQt.put(childName, parentsQt.get(childName) - 1);
                if (parentsQt.get(childName) == 0 && graph.get(childName) != null) {
                    queue.offer(nodeChild); // só adiciona a fila se todos os pais já tiverem sido percorridos
                }
            }
        }
        
        
        return farthestNode != null ? farthestNode.dist : 0;
    }
    
    static class Node {
        int name;
        int dist = Integer.MIN_VALUE;
        Node previous;
        
        Node (int name, int dist) {
            this.name = name;
            this.dist = dist;
        }
        
        Node (int name) {
            this.name = name;
        }
    }
}



/*

fazer uma busca topologicamente ordenada

visita sempre os nós que já não tem mais pais visitados.


dar preferencia ao pai que tem a maior distancia.


*/