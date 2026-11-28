package codesignal.introductionToHashTablesAndHashMapsInJava;

/*
https://codesignal.com/learn/course/481/unit/1/practice/4

You are given a list of n strings of varied lengths. Write a function findAnagrams(String[] strs) that takes this list and returns a list of lists. 
Each sublist should contain strings that are anagrams of each other, sorted in lexicographical order. 
The final list of lists should also be sorted lexicographically by the first string in each sublist.

In this problem, an anagram is defined as a word or phrase that is formed by rearranging the letters of a different word or phrase. 
For example, the words cinema and iceman are anagrams because they contain the same letters.

Your solution should have a time complexity of $O(n \cdot m \cdot \log m)$, where n is the number of strings in the list, 
and m is the maximum length of a string in the list.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public static List<List<String>> findAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            
            String sortedStr = new String(arr);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            map.put(sortedStr, list);
            
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            
            List<String> list = entry.getValue();
            
            Collections.sort(list);
            
            result.add(list);
        }
        
        Collections.sort(result, Comparator.comparing(a -> a.get(0)));
        
        return result;
    }
}
