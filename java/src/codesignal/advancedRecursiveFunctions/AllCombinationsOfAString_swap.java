package codesignal.advancedRecursiveFunctions;
/*
Given a string s of n characters, your task is to write a Java function called allCombinations that uses a 
recursive algorithm to generate and return a list of all possible combinations of the characters in the string, 
including the original string and its reverse. The combinations should be sorted in alphabetical order.

For instance, if the input is 'abc', the function should return a list of all possible combinations: 
['a', 'ab', 'abc', 'ac', 'acb', 'b', 'ba', 'bac', 'bc', 'bca', 'c', 'ca', 'cab', 'cb', 'cba'].

https://codesignal.com/learn/course/480/unit/5/practice/2


*/
import java.util.*;
public class AllCombinationsOfAString_swap {
    public static List<String> allCombinations(String s) {
        char[] options = s.toCharArray();
        Arrays.sort(options);
        
        Set<String> set = new HashSet<>();
        
        backtracking(options, 0, set);
        
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);        
        return result;
    }
    
    public static void backtracking(char[] options, int s, Set<String> set) {
        
        if (s > 0) {
            String str = new String(options);
            set.add(str.substring(0, s));
        }
        
        if (s == options.length) {
            return;
        }
        
        for (int i = s; i < options.length; i++) {            
            swap(options, s, i);
            backtracking(options, s + 1, set);
            swap(options, s, i);
        }
        
    }
    
    public static void swap(char[] word, int i, int j) {
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
    }
    
}