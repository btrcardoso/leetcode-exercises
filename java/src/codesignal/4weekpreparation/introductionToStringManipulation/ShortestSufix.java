package codesignal.introductionToStringManipulation;

/*
https://codesignal.com/learn/course/479/unit/3/practice/2

You are given an array of n strings. Your task is to find the longest common suffix shared among all strings in the array. A suffix is a sequence of letters at the end of a word. For instance, in the word "flying," "ing" is a suffix.

If the given array is empty or there is no common suffix among the strings, your function should return an empty string.

For example, given an array of strings: ["barking", "parking", "starking"], the longest common suffix is "arking".

*/

public class ShortestSufix {
        public static String solution(String[] strs) {
        
        if (strs.length == 0) return "";
        
        String shortest = strs[0];
        for (String str : strs) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        
        for (int i = 0; i < shortest.length(); i++) {
            
            char cs = shortest.charAt(shortest.length() - 1 - i);
            
            for (String str : strs) {
                if (str.charAt(str.length() - 1 - i) != cs) {
                    return shortest.substring(shortest.length() - i, shortest.length());
                }
            }
            
        }
        
        return shortest;
    }
}
