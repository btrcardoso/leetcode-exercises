package codesignal.advancedGraphAlgorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*

Given a directed acyclic graph (DAG) as an adjacency list, where keys represent nodes and values represent edges from that node to other nodes, implement a function, topologicalSort(Map<String, List<String>> graph), that performs a topological sort on this graph. The function should return a list containing all the nodes of the graph in topological order.

If multiple topological orders are possible, the function can return any one of them. If you are unfamiliar, a topological order of a DAG is a linear ordering of its nodes such that for every directed edge u -> v from node u to node v, u comes before v in the ordering.

Map<String, List<String>> graph = new HashMap<>();
graph.put("A", Arrays.asList("B", "C"));
graph.put("B", Arrays.asList("D"));
graph.put("C", Arrays.asList("D"));
graph.put("D", new ArrayList<>());

List<String> result = Solution.topologicalSort(graph);
System.out.println(result);

a
| \
b  c
\ /
 d 

*/

public class TopologicalSort {
    public static List<String> topologicalSort(Map<String, List<String>> graph) {
    
        // check nodes with/without parents
        Map<String, Integer> parentsQuantity = new HashMap<>();
        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            
            Integer qt = parentsQuantity.get(node.getKey());
            if (qt == null) {
                parentsQuantity.put(node.getKey(), 0);
            }
            
            for (String child : node.getValue()) {
                qt = parentsQuantity.getOrDefault(child, 0) + 1;
                parentsQuantity.put(child, qt);
            }            
        }
        
        Queue<String> queue = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        
        // add parents in queue
        for (Map.Entry<String, Integer> qt : parentsQuantity.entrySet()) {
            if (qt.getValue() == 0) {
                queue.offer(qt.getKey());
            }
        }        

        // bfs
        while (queue.size() > 0) {
            String node = queue.poll();
            result.add(node);
            
            for (String child : graph.get(node)) {
                parentsQuantity.put(child, parentsQuantity.get(child) - 1);
                if (parentsQuantity.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }       
        
        return result;
    }
}
