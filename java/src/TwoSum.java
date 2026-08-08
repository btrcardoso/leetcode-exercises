
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
    Time complexity = sorting algorithm => n log n => O(n log n)
    Space complexity = 2n => O(n)

    A = 
    [2,0]        <- i
    [7,1]
    [11,2]
    [15,3]       <- j
    (value, idx)
    */
    public int[] twoSum_sorting(int[] nums, int target) {

        int[][] A = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            A[i][0] = nums[i];
            A[i][1] = i;
        }

        Arrays.sort(A, Comparator.comparingInt(a -> a[0]));

        int i = 0, j = nums.length - 1;
        int[] result;

        while (i < j) {
            int sum = A[i][0] + A[j][0];

            if (sum == target) {
                result = new int[]{A[i][1], A[j][1]};
                Arrays.sort(result);

                return result;
            } else if (sum > target) {
                j--;                   // reduces idx of biggest
            } else {
                i++;                   // increases idx of least
            }
        }

        return new int[]{-1,-1};

    }

    
    /*
    Time complexity: 2n = O(n)
    Space complexity: 2n = O(n)

    */
    public int[] twoSum_HashMap(int[] nums, int target) {

        Map<Integer, Integer> mapValueIndex = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            mapValueIndex.put(nums[i], i);
        }

        for (Integer i = 0; i < nums.length - 1; i++) {

            Integer diff = target - nums[i];
            Integer j = mapValueIndex.get(diff);
            if (j != null && i != j) {
                return new int[]{i,j};
            }

        }

        return new int[]{-1,-1};

    }


    public int[] twoSum_TwoPointers(int[] nums, int target) {

        if(nums.length < 2) return new int[]{-1,-1}; 

        int l = 0;

        while (l < nums.length - 1) {

            int r = l+1;

            while(r < nums.length) {

                if (nums[l] + nums[r] == target) {
                    return new int[]{l,r};
                }

                r++;

            }

            l++;
        }

        return new int[]{1,-1};
        
    }

    /*
    Time complexity: (n^2 - n) / 2 = O(n^2)
    Space complexity: O(1)

    */
    public int[] twoSum_Array(int[] nums, int target) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }

            }

        }

        return new int[]{-1,-1};
        
    }
}
