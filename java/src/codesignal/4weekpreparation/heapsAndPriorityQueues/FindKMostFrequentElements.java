package codesignal.heapsAndPriorityQueues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://codesignal.com/learn/course/481/unit/2/practice/1

You are given an array of n integers where some integers are repeated. 
Write a function in Java that takes this array and an integer k as inputs. 
The function needs to return the k most frequent elements from the array in descending order of their frequency. 
If two numbers have the same frequency, return them in ascending order. 
You should optimize your solution by leveraging Java's PriorityQueue class.

The expected time complexity of the solution should be $O(n \log k)$.




*/

public class FindKMostFrequentElements {
    
    /*
    Space complexity: O(n) worst case
    Time complexity: O(n.log k)
    */
    public static List<Integer> solution(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>(k , new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if (a.qt == b.qt) {
                    return a.num == b.num ? 0 : a.num > b.num ? -1 : 1;
                }
                return a.qt < b.qt ? -1 : 1;
            }            
        });
        
        // O(n log k)
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            Node node = new Node(entry.getKey(), entry.getValue());
                
            if (minHeap.size() < k) {
                minHeap.add(node);
                
            } else if (entry.getValue() == minHeap.peek().qt && entry.getKey() < minHeap.peek().num) {
                minHeap.poll();
                minHeap.add(node);
                
            } else if (entry.getValue() > minHeap.peek().qt) {
                minHeap.poll();
                minHeap.add(node);
            }
            
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < k && !minHeap.isEmpty(); i++) {
            res.add(0, minHeap.poll().num);
        }
        
        
        return res;
    }
    
    static class Node {
        int num;
        int qt;
        
        Node (int num, int qt) {
            this.num = num;
            this.qt = qt;
        }
    }
}
