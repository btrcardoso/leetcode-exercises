package codesignal.introductionToHashTablesAndHashMapsInJava;

import java.util.HashMap;
import java.util.Map;

public class DetectNearbyDuplicates {
    public static boolean solution(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer lastIdx = map.get(nums[i]);
            
            if (lastIdx != null && i - lastIdx <= k) {
                return true;
            }
            
            map.put(nums[i], i);
        }
        
        return false;
    }
}
