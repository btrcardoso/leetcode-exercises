package codesignal.heapsAndPriorityQueues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Your task is to write a function that takes a list of strings and an integer k as input. 
The function should return the k shortest strings in the list in ascending order of their lengths. 
In the case of ties, prioritize the strings that come earlier in the original list.

For instance, if the input list is ['cat', 'window', 'defenestrate', 'python', 'algorithm'] and k = 2, 
the output should be ['cat', 'window'] because they are the two strings with the shortest lengths.

The solution should work in O(n log k) time complexity, where n is the number of strings in the list.

Hint: Consider using a priority queue to efficiently manage and retrieve the strings based on their lengths 
and original order in the list.


*/

public class FindKShortestStringInAList {
    public static List<String> findKShortest(List<String> strings, int k) {
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(k, new Comparator<Pair>(){
            public int compare (Pair a, Pair b) {
                if (a.str.length() == b.str.length()) {
                    return b.idx - a.idx;
                }                
                return b.str.length() - a.str.length();
            }
        });
        
        for (int i = 0; i < strings.size(); i++) {
            Pair pair = new Pair(strings.get(i), i);
            
            if (maxHeap.size() < k) {
                maxHeap.add(pair);
                
            } else if (strings.get(i).length() < maxHeap.peek().str.length()){
                maxHeap.poll();
                maxHeap.add(pair);
            } 
        }
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            result.add(0, maxHeap.poll().str);
        }
        
        return result;
    }
    
    static class Pair {
        String str;
        int idx;
        
        Pair (String str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }
}
