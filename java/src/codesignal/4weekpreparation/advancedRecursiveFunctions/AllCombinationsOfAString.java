package codesignal.advancedRecursiveFunctions;
/*
Given a string s of n characters, your task is to write a Java function called allCombinations that uses a 
recursive algorithm to generate and return a list of all possible combinations of the characters in the string, 
including the original string and its reverse. The combinations should be sorted in alphabetical order.

For instance, if the input is 'abc', the function should return a list of all possible combinations: 
['a', 'ab', 'abc', 'ac', 'acb', 'b', 'ba', 'bac', 'bc', 'bca', 'c', 'ca', 'cab', 'cb', 'cba'].

https://codesignal.com/learn/course/480/unit/5/practice/2


*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombinationsOfAString {
    public static List<String> allCombinations(String s) {
        List<String> result = new ArrayList<>();
        char[] options = s.toCharArray();
        Arrays.sort(options);
        backtracking(options, new ArrayList<>(), result);
        return result;
    }
    
    
    public static void backtracking(char[] options, List<Character> cur, List<String> result){
                
        if (!cur.isEmpty()) {
            result.add(toStr(cur));
        }
        
        for (int i = 0; i < options.length; i++) {
            
            if (options[i] == '#' || (i > 0 && options[i] == options[i-1])) {
                continue;
            }
            
            char temp = options[i];
            options[i] = '#';
            
            cur.add(temp);
            backtracking(options, cur, result);
            cur.remove(cur.size() - 1);
            
            options[i] = temp;
            
            
        }
        
    }
    
    public static String toStr(List<Character> chars) {
        
        StringBuilder sb = new StringBuilder();
        
        for (Character c : chars) {
            sb.append(c);
        }
        
        return sb.toString();        
    }
}