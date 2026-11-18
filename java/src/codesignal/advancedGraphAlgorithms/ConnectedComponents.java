package codesignal.advancedGraphAlgorithms;

import java.util.*;

/*
https://codesignal.com/learn/course/481/unit/3/practice/1

Reset chat
You are given the adjacency-list representation of an undirected graph with nodes labeled 0 to n - 1, 
where n == graph.size(). Each node’s adjacency list contains its neighbors and the edge weight. 
Your task is to return the number of distinct connected components in the graph.

Input Format

The argument type is List<List<int[]>> graph.
graph.get(u) is the adjacency list for node u.
Each item in graph.get(u) is an int[2] array:
neighbor[0] → the neighbor node v
neighbor[1] → the edge weight w (non-negative). For this problem, ignore the weight.
The graph is undirected: if there is an edge between u and v, both adjacency lists will typically contain it (i.e., u -> v and v -> u). 
Your algorithm should work even if duplicate edges or self-loops appear.
An empty inner list means the node has no neighbors.
Valid node indices are in [0, n - 1].
Examples

If graph.get(2) is [[1, 5], [3, 2]], then node 2 has edges to nodes 1 (weight 5) and 3 (weight 2).
A single isolated node: graph = [ [[0, 0]] ] (a self-loop). Number of components = 1.
Two isolated nodes: graph = [ [], [] ]. Number of components = 2.
Your goal is to compute the number of connected components. 
A connected component is a maximal set of nodes where every pair is connected by a path.

Connected components of a graph are subgraphs in which any two vertices are connected to each other by paths, 
and which are connected to no additional vertices in the supergraph. In other words, 
a connected component is a maximal set of nodes where there is a path between any pair of nodes within the set.

The expected time complexity is $O(n + m)$, where $n$ is the number of vertices and $m$ is the number of edges in the graph.


*/

public class ConnectedComponents {
    
    public static int solution(List<List<int[]>> graph) {
        
        if (graph.size() == 0) return 0;
        
        Set<Integer> visited = new HashSet<>();        
        Queue<Integer> queue = new ArrayDeque<>();
        int connectedComponents = 0;
        int i = 0;
        
        while (visited.size() < graph.size() && i < graph.size()) {
            
            if (!visited.contains(i)) {
                queue.offer(i);
                visited.add(i);
                
                // bfs
                while (queue.size() > 0) {
                    Integer node = queue.poll();
                    
                    List<int[]> neighborhood = graph.get(node);
                    for (int[] neighbor : neighborhood) {
                        int neighborId = neighbor[0];
                        if (!visited.contains(neighborId)) {
                            queue.add(neighborId);
                            visited.add(neighborId);
                        }
                    }
                }
                
                connectedComponents++;   
            } 
                        
            i++;                 
        }      
        
        return connectedComponents;
    }
}

/*


graph

0 -> {{1,20}, {2,30}}
1 -> {{0,20}}
2 -> {{0,30}}
3 -> {{4,50}}
4 -> {{3,50}}
5 -> {{}}


totalNodes = graph.size() = 6

connectedComponents = 0

visited: 0,1,2
connectedComponents = 1
visited < totalNodes 

visited 0,1,2,3,4
connectedComponents = 2
visited < totalNodes 

visited 0,1,2,3,4,5
connectedComponents = 3
visited == totalNodes, finaliza

*/