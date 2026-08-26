package help;

import java.util.*;

public class InterestingDataStructures {
    void datastructures() {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,100);
        map.get(1); // retorna 100
        
        map.values(); // retorna todos os valores em Collection
        map.keySet(); // retorna todas as chaves em Set

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.remove(1); // returns true if removes

        String str = "";
        char[] charStr = str.toCharArray();
        String backToStr  =new String(charStr);

        Queue<Character> queue = new ArrayDeque<>();
        queue.add('a');
        queue.add('b');
        queue.poll(); // remove retorna 'a'
        queue.peek(); // shows the first one

        StringBuilder sb = new StringBuilder();
        String reverted = sb.reverse().toString();

        // Instanciar arrays
        int[] nums = new int[5];
        int[] nums2 = {1,2,3};
        Arrays.sort(nums2);

        String txt = "oi";
        txt.length();                  // O(1)
        txt.indexOf("i");         // O(n) pior caso
        txt.split("");          // O(n)
        txt.substring(1);  // O(1) to find, O(n) to copy the string into another

    }
}
