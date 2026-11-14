package codesignal.advancedRecursiveFunctions;

/*
https://codesignal.com/learn/course/480/unit/5/practice/5


As part of the team of software engineers at XYZ Corp, you're working on a new word game. 
The game takes an array of n strings, where each string contains m characters. 
Your task is to design a Java program that returns all combinations of the characters in the strings by taking one 
character from each string to form a unique word. Words should be returned in alphabetical order. Use a recursive approach to solve this problem.

Return a list of all the new words.

For example, for words = {"abc", "def", "ghi"}, the output should be 
{"adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", 
 "bdg", "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", 
 "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi"}.


*/

import java.util.*;
 
public class WordCombinationGenerator {
    public static List<String> solution(String[] words) {
        List<String> result = new ArrayList<>();        
        backtracking("", 0, words, result);
        Collections.sort(result);
        return result;
    }
    
    public static void backtracking(String cur, int wId, String[] words, List<String> result){
        
        if (wId == words.length) {
            result.add(cur);
            return;
        }
        
        String word = words[wId];
        for (int i = 0; i < word.length(); i++) {
            backtracking(cur + word.charAt(i), wId + 1, words, result);
        }
    }
}
/*

                 a                           b                           c
        d        e        f         d        e        f         d        e        f  
      g h i    g h i    g h i     g h i    g h i    g h i     g h i    g h i    g h i 

*/