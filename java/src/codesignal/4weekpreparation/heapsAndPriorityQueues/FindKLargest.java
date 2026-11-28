package codesignal.heapsAndPriorityQueues;

import java.util.PriorityQueue;

public class FindKLargest {
    public static PriorityQueue<Integer> findKLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {

            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }

        }

        return new PriorityQueue<>(minHeap);
    }
}
