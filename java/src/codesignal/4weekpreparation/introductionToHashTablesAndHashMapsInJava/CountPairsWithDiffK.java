package codesignal.introductionToHashTablesAndHashMapsInJava;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithDiffK {
    public static int countPairsWithDiffK(int[] nums, int k) {
        
        if (k == 0) return 0;
       
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            Integer qt = map.get(nums[i] + k);
            if (qt != null) {
                count += qt;
            }
            
            qt = map.get(nums[i] - k);
            if (qt != null) {
                count += qt;
            }
            
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
       
        return count;
    }
}
