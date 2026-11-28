package codesignal.introductionToStringManipulation;

import java.util.HashMap;
import java.util.Map;


/*
You are given a string of characters. Your task is to write a function that will find and return the most common substring of a given length in the input string. If two or more substrings have the same maximum frequency, you should return the lexicographically smallest one.

For example, given the input string "bananabananaba" and a substring length of 5, your function should return "anaba", since it appears twice and is lexicographically smaller than other substrings that also appear twice (e.g., "banan").

The expected time complexity for this task is $O(str.length \cdot length)$.





*/
public class FindMostCommonSubstring {
     public static String findMostCommonSubstring(String s, int k) {
        
        int maxQt = 0;
        Map<String, Integer> map = new HashMap<>();
        String maxString = "";
        
        for (int i = 0; i < s.length() - k + 1; i++) {
            String curString = s.substring(i, i + k);
            
            int qt = map.getOrDefault(curString, 0) + 1;
            map.put(curString, qt);
            
            if (maxQt < qt) {
                maxQt = qt;
                maxString = curString;
            }
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxQt) {
                if (entry.getKey().compareTo(maxString) < 0) {
                    maxString = entry.getKey();
                }
            }
        }
        
        return maxString;
    }
}
