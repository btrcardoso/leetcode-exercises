import java.util.*;

public class MinimumWindowWithCharcaters {
    
    public String minWindow(String s, String t) {

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            int qt = tMap.getOrDefault(c, 0) + 1;
            tMap.put(c, qt);
        }

        int resR = Integer.MAX_VALUE, resL = 0, l = 0, r = 0;

        while (l < s.length()) {

            while (!tMap.containsKey(s.charAt(l))) {
                l++;

                if (l == s.length()) {
                    return resR == Integer.MAX_VALUE ? "" : s.substring(resL, resR);
                }
            }

            if (l > r) {
                r = l;
            }

            while (r < s.length() && !satisfy(tMap, sMap)) {
                char rChar = s.charAt(r);
                if (tMap.containsKey(rChar)) {
                    int qt = sMap.getOrDefault(rChar, 0) + 1;
                    sMap.put(rChar, qt);
                }

                r++;
            }

            if (satisfy(tMap, sMap) && (resR - resL > r - l)) {
                resR = r;
                resL = l;
            }

            char lChar = s.charAt(l);
            int qt = sMap.get(lChar);
            sMap.put(lChar, qt - 1);

            if (sMap.get(lChar) == 0) {
                sMap.remove(lChar);
            }

            l++;

        }


        return resR == Integer.MAX_VALUE ? "" : s.substring(resL, resR);
        
    }

    // O(t)
    private boolean satisfy(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {

        for (Map.Entry<Character, Integer>  entry : tMap.entrySet()) {

            Character tKey = entry.getKey();
            Integer tValue = entry.getValue();

            if (!sMap.containsKey(tKey) || sMap.get(tKey) < tValue) {
                return false;
            }

        }

        return true;

    }


}


/*

OUZODYXAZV

XYZ



l
r
OUZODYXAZV

 l
 r
OUZODYXAZV

  l
  r
OUZODYXAZV

  l
      r
OUZODYXAZV



     l
      r
OUZODYXAZV

     l
        r
OUZODYXAZV


      l
        r
OUZODYXAZV


      l
         r <- r is final. end the loop.
OUZODYXAZV




walk with l until the element is inside the tMap.
walk with r until the ssMap == tMap.


Space complexity: O(k) , k = caracteres distintos em t
Time complexity = O(s * t)






*/