package codesignal.heapsAndPriorityQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindStreamMedian {
    public static List<Double> findStreamMedian(List<Integer> numbers) {
        
        PriorityQueue<Integer> biggestInLeft = new PriorityQueue<>((a,b) -> b-a);   // maxHeap     
        PriorityQueue<Integer> smallestInRight = new PriorityQueue<>();             // minHeap     
        
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            
            Integer num = numbers.get(i);
            Double median;
            
            if (biggestInLeft.size() == smallestInRight.size()) {
                
                if (smallestInRight.peek() != null && num > smallestInRight.peek()) {
                    biggestInLeft.offer(smallestInRight.poll());
                    smallestInRight.offer(num);
                } else {
                    biggestInLeft.offer(num);
                }
                
                median = Double.valueOf(biggestInLeft.peek());
                
            } else {
                
                if (biggestInLeft.peek() != null && num < biggestInLeft.peek()) {
                    smallestInRight.offer(biggestInLeft.poll()); 
                    biggestInLeft.offer(num);
                } else {
                    smallestInRight.offer(num);
                }                
                
                median = (biggestInLeft.peek() + smallestInRight.peek()) / 2.0;
                
            }
            
            result.add(median);           
            
        }
        
        return result;
    }
}


/*
6, 2, 3,   1, 5,   4
6, 4, 3, 2.5, 3, 3.5 


biggestInLeft =
smallestInRight = 

6
biggestInLeft = 6
smallestInRight = 
median = 6

6 2
biggestInLeft = 2
smallestInRight = 6
median = 4

6 2 3
biggestInLeft = 3 2
smallestInRight = 6
median = 3

6 2 3 1
biggestInLeft = 2 1
smallestInRight = 3 6
median = 2.5

6 2 3 1 5
biggestInLeft = 3 2 1
smallestInRight = 5 6 
median = 3

6 2 3 1 5 4
biggestInLeft = 3 2 1
smallestInRight = 4 5 6 
median = 3.5

*/
