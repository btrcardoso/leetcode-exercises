package codesignal.advancedRecursiveFunctions;

/*
Given an integer n, your task is to return a list of strings with all the possible combinations of n pairs of parentheses that are correct.
 A correct combination of parentheses is one where every opening bracket has a corresponding closing bracket. 
 You should use a recursive approach to solve this problem.

For example, given n = 3, the possible combinations would be ["((()))", "(()())", "(())()", "()(())", "()()()"].

*/


import java.util.*;

public class GeneratingBalancedParentheses {
    
    
    private static final Character OPEN = '(';
    private static final Character CLOSE = ')';
    
    public static List<String> generateParentheses(int n) {
        Map<Character, Integer> map = new HashMap<>();
        map.put(OPEN, n);
        map.put(CLOSE, n);
        
        List<String> result = new ArrayList<>();
        if (n > 0) {
            backtracking("", map, result);
        }
        
        return result;
    }
    
    public static void backtracking(String cur, Map<Character, Integer> map, List<String> result) {
        
        int qtOpen = map.get(OPEN);
        int qtClose = map.get(CLOSE);
        
        if (qtOpen > qtClose) {
            return;
        }
        
        if (qtOpen == 0 && qtClose == 0) {
            result.add(cur);
            return;
        }
        
        if (qtOpen > 0) {
            map.put(OPEN, qtOpen - 1);
            backtracking(cur + OPEN, map, result);
            map.put(OPEN, qtOpen);
        }
        
        if (qtClose > 0) {
            map.put(CLOSE, qtClose - 1);
            backtracking(cur + CLOSE, map, result);
            map.put(CLOSE, qtClose);
        }
        
    }
}