import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {

    }

    /*
    Time complexity: n + m => O(n + m)
    Space complexity: 26 = O(1) 
    */
    public boolean isAnagram_HashTable(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {

            count[s.charAt(i) - 'a'] ++;
            count[s.charAt(i) - 'a'] --;

        }

        for( int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    /*
    Time complexity: considering sort algorithm = n log n => O (n log n + m log m) 
    Space complexity: n + m = O(n + m) 
    */
    public boolean isAnagram_Sort(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);

    }

    /*
    HashMap as HashTable
    Time complexity: n + m = O(n + m)
    Space complexity: 26 = O(1) 
    */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character letter = s.charAt(i);
            Integer qt = map.getOrDefault(letter, 0);
            map.put(letter, qt + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Character letter = t.charAt(i);
            Integer qt = map.get(letter);

            if (qt == null) {
                return false;
            } else if (qt == 1) {
                map.remove(letter);
            } else if (qt > 1) {
                map.put(letter, qt - 1);
            }
        }

        return map.size() == 0;

    }
}
