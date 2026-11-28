package codesignal.introductionToHashTablesAndHashMapsInJava;

/*
You are required to find the number of pairs where one element is selected from array a and the other element is selected from array b,
 such that their sum is equal to the given number num.

 https://codesignal.com/learn/course/481/unit/1/practice/3

The expected time complexity for the task is $O(\text{len}(a) + \text{len}(b))$.

*/

import java.util.HashMap;
import java.util.Map;

public class FindingPairsWithGivenSum {
     public static int sumPairs(int[] a, int[] b, int num) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : a) {
            map.put(element, map.getOrDefault(element,0) + 1);
        }
        
        int count = 0;
        for (int element : b) {
            count += map.getOrDefault(num - element, 0);
        }
        
        return count;
    }
}
