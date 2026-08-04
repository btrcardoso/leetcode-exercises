
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i< nums.length ; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i< nums.length ; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }

        return new int[] {};
    }



    // public int[] twoSum(int[] nums, int target) {

    //     for (int i=0; i<nums.length; i++) {

    //         for (int j=i+1; j<nums.length; j++) {

    //             if (nums[i] + nums[j] == target) {
    //                 return new int[]{i, j};
    //             }

    //         }

    //     }

    //     return new int[]{-1, -1};
    // }
}
