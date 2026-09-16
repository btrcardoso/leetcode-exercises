package hackerhank;

public class JavaAnagrams {
    static boolean isAnagram(String a, String b) {
        
        if (a.length() != b.length()) {
            return false;
        }
        
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        int[] freq = new int[26];
        
        for (int i=0; i< a.length(); i++) {
          freq[a.charAt(i) - 'a']++;
          freq[b.charAt(i) - 'a']--;
        }
        
        for (int i=0; i< 26; i++) {
          if(freq[i] != 0) {
            return false;
          }
        }
        
        return true;
        
    }
}
