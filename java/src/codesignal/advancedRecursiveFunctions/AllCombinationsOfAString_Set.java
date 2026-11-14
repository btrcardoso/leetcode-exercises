package codesignal.advancedRecursiveFunctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string s of n characters, your task is to write a Java function called allCombinations that uses a 
recursive algorithm to generate and return a list of all possible combinations of the characters in the string, 
including the original string and its reverse. The combinations should be sorted in alphabetical order.

For instance, if the input is 'abc', the function should return a list of all possible combinations: 
['a', 'ab', 'abc', 'ac', 'acb', 'b', 'ba', 'bac', 'bc', 'bca', 'c', 'ca', 'cab', 'cb', 'cba'].

https://codesignal.com/learn/course/480/unit/5/practice/2


*/

// written by codesignal
public class AllCombinationsOfAString_Set {
    public static List<String> allCombinations(String s) {
        Set<String> result = new HashSet<>();
        generate("", s, new HashSet<>(), result);
        
        List<String> sorted = new ArrayList<>(result);
        Collections.sort(sorted);
        return sorted;
    }

    private static void generate(String path, String s, Set<Integer> used, Set<String> result) {
        if (!path.isEmpty()) {
            result.add(path);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!used.contains(i)) {
                used.add(i);
                generate(path + s.charAt(i), s, used, result);
                used.remove(i);
            }
        }
    }
}
