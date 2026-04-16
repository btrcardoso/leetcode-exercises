//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/?envType=problem-list-v2&envId=sliding-window
import java.util.*;
// TODO: try again

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    // tentando, n funciona

    public int longestSubstring(String s, int k) {
        Map<Character, Integer> letters = new HashMap<>();
        Character character;
        Integer quantity;

        int l=0;
        int longestSubstring = 0;

        for (int r=0; r<s.length(); r++)  {
            character = s.charAt(r);
            quantity = letters.get(character);
            letters.put(character, quantity == null ? 1 : quantity++);

            while (!letters.isEmpty() && letters.values().stream().allMatch(val -> val < k)) {
                character = s.charAt(l);
                quantity = letters.get(character);

                if (quantity == 1) {
                    letters.remove(character);
                } else {
                    letters.put(character, quantity--);
                }

                l++;
            }

            if (r-l+1 > longestSubstring) {
                longestSubstring = r-l+1;
            }
        }


        return longestSubstring;

    }

    // Time Limit Exceeded
//    public int longestSubstring(String s, int k) {
//        Map<Character, Integer> letters;
//        int longestSubstring = 0;
//
//        for (int l=0; l<s.length() ; l++) {
//            letters = new HashMap<>();
//
//            if (longestSubstring > s.length() - l) {
//                break;
//            }
//
//            for (int r=l; r<s.length(); r++)  {
//                Character character = s.charAt(r);
//                Integer quantity = letters.get(character);
//                letters.put(character, quantity == null ? 1 : quantity+1);
//
//                boolean allGreaterThanK = letters.values().stream().allMatch(val -> val >= k);
//                int substringLen = r-l+1;
//
//                if (allGreaterThanK && substringLen > longestSubstring) {
//                    longestSubstring = substringLen;
//                }
//
//            }
//
//        }
//
//        return longestSubstring;
//
//    }
}
