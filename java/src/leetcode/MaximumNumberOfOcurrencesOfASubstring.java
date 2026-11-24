package leetcode;

import java.util.*;
// https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

public class MaximumNumberOfOcurrencesOfASubstring {
    // solution using rabin karp, there are some better ones
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        Map<Character, Integer> uniqueLetters = new HashMap<>();
        Map<Long, Integer> frequency = new HashMap<>();

        int max = 0;

        long hash = 0; // represents the substring
        long base = 31;

        // create first substring
        for (int i = 0; i < minSize; i++) {
            char c = s.charAt(i);
            hash = hash * base + c;
            uniqueLetters.put(c, uniqueLetters.getOrDefault(c, 0) + 1);
        }
        if (uniqueLetters.size() <= maxLetters) {
            frequency.put(hash, 1);
            max = Math.max(frequency.get(hash), max);
        }

        long firstPower = (long) Math.pow(base, minSize - 1);

        // slide window, saving max
        for (int i = minSize; i < s.length(); i++) {
            char oldChar = s.charAt(i - minSize);
            char newChar = s.charAt(i);

            hash = (hash - oldChar * firstPower) * base + newChar;

            uniqueLetters.put(oldChar, uniqueLetters.get(oldChar) - 1);
            if (uniqueLetters.get(oldChar) == 0) uniqueLetters.remove(oldChar);
            
            uniqueLetters.put(newChar, uniqueLetters.getOrDefault(newChar, 0) + 1);

            if (uniqueLetters.size() <= maxLetters) {
                frequency.put(hash, frequency.getOrDefault(hash, 0) + 1);
                max = Math.max(frequency.get(hash), max);
            }
        }

        return max;
        
    }
}

/*

só precisa conferir as substrings minSize, pq elas sempre terão uma quantidade maior ou igual a maxSize.





Map<Character, Integer> uniqueLetters = new HashMap<>();
Map<Long, Integer> substringQuantity = new HashMap<>();





*/