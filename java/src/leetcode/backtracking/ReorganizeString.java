package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class ReorganizeString {


    class Node {
        public char c;
        public int qt;

        Node (char c, int qt) {
            this.c = c;
            this.qt = qt;
        }
    }

    public String reorganizeString(String s) {

        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return Integer.compare(n2.qt, n1.qt);
            }
        });

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        int i = 0;
        StringBuilder sb = new StringBuilder();
        char last = '#';

        while (queue.size() > 0) {
            Node node = queue.remove();

            if (node.c != last) { // add the one with most frequency
                sb.append(node.c);
                node.qt--;
                last = node.c;

            } else if (queue.size() > 0) {      // add the one with the second biggest frequency
                Node nextNode = queue.remove();

                sb.append(nextNode.c);
                nextNode.qt--;
                last = nextNode.c;

                if (nextNode.qt > 0) {
                    queue.add(nextNode);
                } 

            } else {
                return "";
            }

            if (node.qt > 0) {
                queue.add(node);
            }            

        }

        return sb.toString();
        
    }


    // ----------------------------------------------------------

    public String reorganizeString_map(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        Character last = '#';

        while (sb.length() < s.length()) {

            Character next = find(last, map);

            if (next == null) {
                return "";
            }

            int qt = map.get(next);
            map.put(next, qt-1);
            if (map.get(next) == 0){
                map.remove(next);
            }

            sb.append(next);
            last = next;

        }

        return sb.toString();
    }


    public Character find(Character notC, Map<Character, Integer> map) {

        int max = Integer.MIN_VALUE;
        Character chosen = null;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            Character key = entry.getKey();
            Integer qt = entry.getValue();

            if (key != notC && qt > max) {
                chosen = key;
                max = qt;
            }

        }

        return chosen;

    }




/*

aaaabc 

a=4
b=1
c=1 como max > todos + 1, return não dá
a

a=3
b=1
c=1
a b

a=3
b=0
c=1
a b a

a=2
c=1
a b a c

a=2
a b a c a

a=1      não dá
a b a c

*/





    //-------------------------------------------------------------




    
    public String reorganizeString_backtracking(String s) {
        return dfs(s.toCharArray(), new ArrayList<>());
    }

    public String dfs(char[] arr, List<Character> list) {

        if (list.size() == arr.length) {
            return list.stream().map(String::valueOf).collect(Collectors.joining());
        }

        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] == '#') ||
                (list.size() > 0 && arr[i] == list.getLast()) ||
                (!seen.add(arr[i]))) {
                continue;
            }

            list.add(arr[i]);
            char temp = arr[i];
            arr[i] = '#';

            String res = dfs(arr, list);
            if (res.length() == arr.length) {
                return res;
            }

            arr[i] = temp;
            list.removeLast();
        }

        return "";

    }
}



/*

backtracking


    [a,a,a,b]

    a
    b
    a
    X



*/
