//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/?envType=problem-list-v2&envId=sliding-window
import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingCharacters {


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
