
import java.util.*;

public class GroupAnagrams {


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

    public List<List<String>> groupAnagrams(String[] strs) { 

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