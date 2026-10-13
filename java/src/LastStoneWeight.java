import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1) {

            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if (x != y) {
                maxHeap.add(Math.abs(x-y));
            }

        }

        return maxHeap.size() > 0 ? maxHeap.peek() : 0;
    }
}
