package codesignal.advancedRecursiveFunctions;

    /*
You are given a string s, your task is to implement a function that returns all possible letter case combinations in the string.

For example, if the input string is s = "a1b2", the output should be ["a1b2", "a1B2", "A1b2", "A1B2"]. 
Another example: if the input string is s = "3z4", the output should be ["3z4", "3Z4"].

Your function should handle both lowercase and uppercase input, and it should treat digits and special characters as invariable elements.
    
https://codesignal.com/learn/course/480/unit/5/practice/4
    */

import java.util.*;

public class LetterCasePermutations {
    public static List<String> solution(String str) {
        str = str.toLowerCase();
        List<String> result = new ArrayList<>();
        backtracking(str.toCharArray(), 0, result);
        return result;
    }
    
    public static void backtracking(char[] str, int s, List<String> result) {
        
        while (s < str.length && !Character.isAlphabetic(str[s])) {
            s++;
        }
        
        if (s == str.length) {
            result.add(new String(str));
            return;
        }
        
        backtracking(str, s+1, result);
        str[s] = Character.toUpperCase(str[s]);
        backtracking(str, s+1, result);
        str[s] = Character.toLowerCase(str[s]);
        
    }
}


/*
                        s
                        a1b2
              s                        s
            a1b2                     A1b2
        s              s            s        s
    a1b2           a1B2         A1b2     A1B2






*/
