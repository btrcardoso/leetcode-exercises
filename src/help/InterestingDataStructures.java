package help;

import java.util.*;

public class InterestingDataStructures {
    void datastructures() {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,100);
        map.get(1); // retorna 100

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

    }

    public static String reverse(String subs) {
        return new StringBuilder(subs).reverse().toString();
    }
}
