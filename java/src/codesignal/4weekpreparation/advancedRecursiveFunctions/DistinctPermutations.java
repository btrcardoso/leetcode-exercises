package codesignal.advancedRecursiveFunctions;

import java.util.*;

public class DistinctPermutations {
    
public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), res);
        return res;
    }
    
    public static void backtracking(int[] nums, List<Integer> cur, List<List<Integer>> res) {
        
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] == -1000 || (i>0 && nums[i] == nums[i-1])) {
                continue;
            }
            
            int temp = nums[i];
            nums[i] = -1000;
            cur.add(temp);
            backtracking(nums, cur, res);
            cur.remove(cur.size() - 1);
            nums[i] = temp;
                
            
        }
        
    }
    
    
}



/*

                     [1123]
    [#123]     [#123]       [11#3]        [112#]
               já foi


    




*/
