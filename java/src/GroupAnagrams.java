
import java.util.*;

public class GroupAnagrams {

    /*

    strs.length: n
    longest word: m

    Time complexity: n * m = O(n*m)
    Space complexity: n * (m + 26)

    */

    public List<List<String>> groupAnagrams_HashTable(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] charStr = str.toCharArray();
            int[] count = new int[26];

            for (int i=0 ;i < charStr.length; i++) {
                count[charStr[i] - 'a'] ++;
            }

            String key = Arrays.toString(count); // 0010000101020300000

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    }


    /*
    ["eat", "tea", "tan", "ate", "nat", "bat"]

    MAP:
    aet-> eat, tea, ate
    ant-> tan, nat
    abt-> bat

    RESULT: [eat, tea, ate], [tan, nat], [bat]



    Time complexity: n * (m log m)  => O(n * m log m)
    Space complexity: n * m => O(n * m)
    
    strs.length: n
    longes word: m
    
    */

    public List<List<String>> groupAnagrams_Sorting(String[] strs) { 

        Map<String, List<String>> map = new HashMap<>(); 
        
        for (String word : strs) {
            
            char[] arrayWord = word.toCharArray();

            Arrays.sort(arrayWord);
            String sortedWord = new String(arrayWord);

            map.putIfAbsent(sortedWord, new ArrayList<>());

            map.get(sortedWord).add(word);

        }

        return new ArrayList<>(map.values());

    }

}

/*

unusedWords -> ["act","pots","tops","cat","stop","hat"]







*/