package codesignal.heapsAndPriorityQueues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortIntegerByAbsoluteMedian {
    public static int[] sortByMedian(int[] nums) {
        
        Arrays.sort(nums);
        
        double median = nums[nums.length / 2];
        if (nums.length % 2 == 0) {
            median = (nums[nums.length / 2] + nums[(nums.length - 1) / 2]) / 2.0;
        }             
        
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                
                if (a.difference == b.difference) {
                    return a.num - b.num;
                }
                
                return a.difference < b.difference ? -1 : 1;
            }
        });
        
        for (int num : nums) {
            heap.add(new Pair(num, Math.abs(num - median)));
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = heap.poll().num;
        }
        
        return nums;
    }
    
    static class Pair {
        int num;
        double difference;
        
        Pair (int num, double difference) {
            this.num = num;
            this.difference = difference;
        }
    }
}
