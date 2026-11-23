package leetcode;

import java.util.*;

public class MaximumNumberOfOcurrencesOfASubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        if (s.length() < minSize) return 0;

        HashMap<Character, Integer> letters = new HashMap<>();
        HashMap<String, Integer> quantity = new HashMap<>();

        for (int i = 0; i < minSize; i++) {
            Character c = s.charAt(i);
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = minSize - 1;

        while (l < s.length() && r < s.length()) {

            int subLen = r - l + 1;

            if (letters.size() <= maxLetters && subLen <= maxSize) {
                String sub = s.substring(l, subLen);
                quantity.put(sub, quantity.getOrDefault(sub, 0) + 1);
            }

            if (letters.size() <= maxLetters && subLen + 1 <= maxSize) {
                r++;

                if (r < s.length()) {
                    Character c = s.charAt(r);
                    letters.put(c, letters.getOrDefault(c, 0) + 1);
                }

            } else {

                int shrink = maxSize - minSize - 1;
                while (shrink > 0) {
                    Character lastChar = s.charAt(r);
                    letters.put(lastChar, letters.get(lastChar) - 1);

                    if (letters.get(lastChar) == 0) {
                        letters.remove(lastChar);
                    }

                    r--;
                    shrink--;
                }

                l++;
                Character c = s.charAt(l);
                letters.put(c, letters.getOrDefault(c, 0) + 1);

            }

        }


        int max = 0;

        for (Map.Entry<String, Integer> qt : quantity.entrySet()) {
            max = Math.max(max, qt.getValue());
        }

        return max;       
        
    }
}


/*

aababcaab

aab
windSize = 3, letters = a,b
aaba
windSize = 4, letters = a,b
aabab
windSize = 5, letters = a,b

 aba
windSize = 3, letters = a,b
 abab
windSize = 4, letters = a,b

  bab
windSize = 3, letters = a,b 
  babc
windSize = 4, letters = a,b,c

   abc
windSize = 3, letters = a,b,c , pula inicio

    bca
windSize = 3, letters = a,b,c , pula inicio

     caa
windSize = 3, letters = a,c 
     caab
windSize = 4, letters = a,c,b

*/