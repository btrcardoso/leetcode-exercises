import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingDouble(point -> 
            Math.sqrt(point[0]*point[0] + point[1]*point[1])
        ));

        for (int i = 0; i < points.length; i++) {
            minHeap.offer(points[i]);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;

    }
}
