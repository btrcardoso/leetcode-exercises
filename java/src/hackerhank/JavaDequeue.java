import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-dequeue/problem?isFullScreen=true

public class JavaDequeue {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            
            Deque<Integer> deque = new ArrayDeque<>();
            Map<Integer, Integer> map = new HashMap<>();
            
            int max = 0;
            
            for (int i = 0; i < n; i++) {
                
                int num = in.nextInt();
                
                deque.addLast(num);
            
                map.put(num, map.getOrDefault(num, 0) + 1);
                
                if (deque.size() > m) {
                    
                    int first = deque.removeFirst();
                    
                    if (map.get(first) == 1){
                        map.remove(first);
                    } else {
                        map.put(first, map.get(first) - 1);
                    }
                    
                }
                
                max = Math.max(max, map.size());
                
            }
            
            System.out.println(max);

            

    }
}
