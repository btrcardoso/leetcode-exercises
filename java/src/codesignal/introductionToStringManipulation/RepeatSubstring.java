package codesignal.introductionToStringManipulation;

/*
https://codesignal.com/learn/course/479/unit/3/practice/3

You are given a string s. Your task is to create a function that checks whether the string s consists of one repeated substring.

If it does, the function should return the substring. If there are multiple possible answers, return the longest one. If it does not consist of a repeated substring, return an empty string.

To clarify, a "repeated substring" refers to a pattern of characters that reoccurs throughout the full string, with no characters left over. For example, the string "abababab" consists of repeated substrings "ab" and "abab". On the other hand, the string "abcabcab" does not consist of a repeated substring, as the final characters "ab" do not complete the repeating pattern of "abc".

*/

public class RepeatSubstring {
    public static String repeatSubstring(String s) {
        
        int i = 2;
        int len = s.length();
        
        while (i <= len) {
            
            if (len % i == 0) {
                
                int subLen = len / i;
                String cur = s.substring(0, subLen);
                
                int j;
                for (j = subLen; j < len; j += subLen) {
                    if (!cur.equals(s.substring(j, j + subLen))) {
                        break;
                    }
                }
                
                if (j == len) {
                    return cur;
                }
                
            }
            
            i++;
        }
        
        return "";
    }
}



/*

abab abab s % 2 == 0, conferir já é..

aba bab ab, s % 3 != 0 , pula

ab ab ab ab s % 4 == 0, conferir


se s/i == 1, confere e retorna













*/