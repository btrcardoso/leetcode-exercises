package leetcode.backtracking;

import java.util.*;

public class Permutations {
    
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    // Time complexity: O(n!.n²)
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;

        dfs(new ArrayList<>());

        return this.res;
    }

    private void dfs(List<Integer> cur) {

        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < -10) {  // Constraint: -10 <= nums[i] <= 10
                continue;
            }

            int val = nums[i];
            nums[i] = -11;

            cur.add(val);
            dfs(cur);
            cur.removeLast();

            nums[i] = val;

        }


    }
}


/*
recursive: [1,2,3]
   1        2       3
  2 3      1 3     1 2
 3   2    3   2   2   1


iterative: [1,2,3]
__   1       2                           3   
[], [1], [2,1][1,2] [3,2,1][2,3,1][2,1,3][3,1,2][1,3,2][1,2,3]  


*/
