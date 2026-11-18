package codesignal.advancedGraphAlgorithms;

/*
https://codesignal.com/learn/course/481/unit/3/practice/2

Your task is to write a Java function shortestPath(boolean[][] grid, int[] source, int[] destination) that takes a given grid of size $n \times n$, a start cell, and a destination cell and determines the shortest path using Dijkstra’s Algorithm. The function should return a list of coordinates representing the path from the source to the destination.

The grid is given as a 2D array of booleans representing the intersections. true means that there is an intersection, and false means that the intersection is blocked. From any intersection, it is possible to move to any directly neighboring intersection (top, bottom, left, or right) if there is a path (true). All paths have the same weight, i.e., 1.

If the path doesn't exist, return an empty list.

*/

import java.util.*;



public class ShortestPath {

    public static List<int[]> shortestPath(boolean[][] grid, int[] source, int[] destination) {
        int m = grid.length;
        int n = grid[0].length;
        
        Set<String> visited = new HashSet<>();
        Map<String, Node> map = new HashMap<>(); 
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance)); // idk if a minHeap is necessary here

        Node node = new Node(source, 0);
        map.put(toString(source), node);
        minHeap.offer(node);
        
        int[][] directions = new int[][]{
            {-1, 0}, // up
            { 1, 0}, // down
            { 0,-1}, // left
            { 0, 1}  // right
        };

        // dijkstra
        while (minHeap.size() > 0) {
            node = minHeap.poll();
            
            if (!visited.add(toString(node))) {
                continue;
            }
                
            for (int[] direction : directions) {
            
                int i = node.i + direction[0];
                int j = node.j + direction[1];
                String code = toString(i, j);
                
                if (0 <= i && i < m && 0 <= j && j < n && grid[i][j] && !visited.contains(code)) {
                    
                    Node neighbor = map.getOrDefault(code, new Node(i, j));
                    
                    if (node.distance + 1 < neighbor.distance){
                        neighbor.distance = node.distance + 1;
                        neighbor.previous = node;
                        
                        minHeap.offer(neighbor);
                    }
                    
                    map.put(code, neighbor);
                    
                }
                
            }         
        }
        
        // make path
        List<int[]> result = new ArrayList<>();
        Node nodeDestination = map.get(toString(destination));
        
        if (nodeDestination != null) {
            Node cur = nodeDestination;
            while (cur != null) {
                result.add(0, new int[]{cur.i, cur.j});
                cur = cur.previous;
            }
        }

        return result; 
    }
    
    private static String toString(Node node){
        return toString(node.i, node.j);
    }
    
    private static String toString(int[] arr){
        return toString(arr[0], arr[1]);
    }
    
    private static String toString(int i, int j) {
        return i + "_" + j;
    }
    
    static class Node {
        int i;
        int j;
        int distance = Integer.MAX_VALUE;
        Node previous;
        
        Node (int i, int j) {
            this.i = i;
            this.j = j;
        }
        
        Node (int[] arr, int distance) {
            this.i = arr[0];
            this.j = arr[1];
            this.distance = distance;
        }
    }
}