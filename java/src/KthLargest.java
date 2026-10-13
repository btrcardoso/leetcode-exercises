import java.util.PriorityQueue;

class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a,b));

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            this.add(num);
        }
    }
    
    public int add(int val) {

        if (minHeap.size() < k) {
            minHeap.add(val);

        } else if (minHeap.peek() < val) {
            minHeap.remove();
            minHeap.add(val);
        }

        return minHeap.peek();
    }
}

/*

In the minHeap, you keep only the k largest values (because you will only add values).

if (minHeap.peek() < val) {
    minHeap.remove();
    minHeap.add(val);
} else {
    // não faz nada, o peek já é o k maior elemento 
}

*/



































// class KthLargest {

//     PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
//         (a,b) -> Integer.compare(b,a)
//     );

//     int k;

//     // Time complexity: O(n)
//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         for (int num : nums) {
//             maxHeap.add(num);
//         }
//     }
    
//     // Time complexity: O(log n * k)
//     // Space complexity: O(k)
//     public int add(int val) {
//         // O(log n)
//         maxHeap.add(val);

//         // O(log n) * k
//         Integer last = null;
//         List<Integer> addLater = new ArrayList<>();
//         for (int i = 0; i < k; i++) {
//             last = maxHeap.poll();
//             addLater.add(last);
//         }

//         // O(log n) * k
//         for (Integer item : addLater) {
//             maxHeap.add(item);
//         }

//         return last;
//     }
// }
