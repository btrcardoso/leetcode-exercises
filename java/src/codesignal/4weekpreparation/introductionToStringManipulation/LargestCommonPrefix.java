package codesignal.introductionToStringManipulation;

import java.util.Arrays;

/*
https://codesignal.com/learn/course/479/unit/3/practice/4

You have been given an array of strings, words. Your task is to implement a function that will find the largest common prefix among the strings in the array. If there is no common prefix, it should return an empty string.

Your task should aim for a solution of complexity $O(words.length \cdot length^2)$, where words.length is the number of strings in the array and length is the length of the smallest string.

For example, largestCommonPrefix(new String[]{"tractor", "traffic", "transmit"}) should output "tra", as it is the largest common prefix for these three strings.
*/

public class LargestCommonPrefix {

    public static String largestCommonPrefix(String[] strs) {
        
        /*
        {"race", "car", "ca", "dog", "aaaaaaaa"}
        [aaaaaaaa, ca, car, dog, race]
        */
        Arrays.sort(strs);
        String s = "";
        int i = 0;
        int length = strs.length;

        while (i < strs[0].length()) {
            if (strs[0].charAt(i) == strs[length - 1].charAt(i))
                s += strs[0].charAt(i);
            else
                break;
            i++;
        }

        return s;
    }

    public static String largestCommonPrefix_(String[] words) {
        
        String shortest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (shortest.length() > words[i].length()) {
                shortest = words[i];
            }
        }
        
        for (int i = shortest.length(); i > 0; i--) {
            
            String curPrefix = shortest.substring(0, i);
            int j;
            
            for (j = 0; j < words.length; j++) {
                
                String curWord = words[j].substring(0, i);
                
                if (!curWord.equals(curPrefix)) {
                    break;
                }
                   
            }
            
            if (j == words.length) {
                return curPrefix;
            }
            
        }     
        
        return "";
    }
}
