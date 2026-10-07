import java.util.*;

public class PermutationInStrings  {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()){
            return false;
        }

        int[] count1 = new int[26]; // count characters in s1
        int[] count2 = new int[26]; // count characters in s2.substring(l, r+1)
        
        
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {

            if (Arrays.equals(count1, count2)) {
                return true;
            }

            // walk with the window
            count2[s2.charAt(l) - 'a'] --;
            count2[s2.charAt(r) - 'a'] ++;
            l++;
        }


        return Arrays.equals(count1, count2);
    }

    // Time complexity: O(m) + Time to make l reaches r
    // Space complexity: O(1), because max length of map is 26. 
    public boolean checkInclusion_(String s1, String s2) {

        // count characters in s1
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++){
            Character c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        while (l < s2.length() && r < s2.length()) {

            Character rChar = s2.charAt(r);

            if (!map.containsKey(rChar)) {           // r is not in s1
                // walk with r
                r++;
                
                // walk with l until it reaches r
                while (l < r) {
                    Character lChar = s2.charAt(l);
                    if (map.containsKey(lChar)) {
                        map.put(lChar, map.get(lChar) + 1);
                    }
                    l++;
                }

            } else if (map.get(rChar) == 0) {      // r is in s1, but has already been used
                Character lChar = s2.charAt(l);

                // add l in the counter if it exists, to see in the next iteration if r wil be in the counter
                if (map.containsKey(lChar)) {
                    map.put(lChar, map.get(lChar) + 1);
                }

                // walk one step with l
                l++;

            } else {                               // r is in s1 and has not been used
                // remove r from the counter
                map.put(rChar, map.get(rChar) - 1);

                // walk one step with r
                r++;
            }

            if (r - l == s1.length()) {
                return true;
            }

        }



        return false;
        
    }
}



/*


sliding window

  l
    r
leacabee

map:
a: 0
b: 1
c: 0

if (!map.contains(rChar) || map.get(rChar) == 0) {
    Character lChar = str2.charAt(l);
    if (map.contains(lChar)) {
        map.put(lChar, map.get(lChar) + 1);
    }
    l++;
} else {
    map.put(rChar, map.get(rChar) - 1);
    r++;
}

   l
    r
leacabee

check

map:
a: 0
b: 1
c: 0




   l
     r
leacabee

check

map:
a: 0
b: 0
c: 0

   l
      r
leacabee

if (r - l == s1.size() ){

return true;

}


*/