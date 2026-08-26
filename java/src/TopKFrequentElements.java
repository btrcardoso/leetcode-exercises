import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    

    /*
    Time complexity: n + n log n + k = O(n log n)
    Space complexity: n + k = O(n + k)
    */

    public int[] topKFrequent_maxHeap(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // log n to add in a priority key
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] pair = new int[]{entry.getKey(), entry.getValue()};
            maxHeap.add(pair);
        }

        int[] result = new int[k];
        for(int i = 0; i<k; i++){
            result[i] = maxHeap.poll()[0];
        }
        return result;

    }


    /*
    Time complexity: n + n log n + k = O (n log n + K)
    Space complexity: 2n + k = O(n + k)
    */

    public int[] topKFrequent_sorting(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        List<int[]> arr = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }
        arr.sort((a,b) -> b[0] - a[0]);
        /*
        Java's sort() comparator works roughly like this:

        negative → a should come before b
        zero → they're considered equal for sorting
        positive → b should come before a
        */

        int[] result = new int[k];

        for (int i=0; i<k; i++) {

            result[i] = arr.get(i)[1];

        }

        return result;
    }

    /*

    Time complexity: n * k * n = O(n^2 * k)
    Space complexity: n + k = O(n+k)

    */
    public int[] topKFrequent_naive(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        int[] result = new int[k];

        for (int i=0; i<k; i++) {

            result[i] = keyMax(map);
            map.remove(result[i]);

        }

        return result;
    }

    public Integer keyMax(Map<Integer, Integer> map) {
        Integer biggest = -1;
        Integer biggestKey = 0;

        for(Integer key : map.keySet()){

            if (map.get(key) > biggest) {
                biggest = map.get(key);
                biggestKey = key;
            }

        }

        return biggestKey;

    }
}
