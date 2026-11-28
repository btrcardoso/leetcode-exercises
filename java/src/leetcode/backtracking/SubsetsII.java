package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://neetcode.io/problems/subsets-ii/history?submissionIndex=1

public class SubsetsII {
    
List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        backtracking(0, nums, new ArrayList<>());
        return result;
    }

    private void backtracking(int i, int[] nums, List<Integer> cur) {

        result.add(new ArrayList<>(cur));

        for (int j = i; j < nums.length; j++) {

            if (j > 0 && nums[j-1] == nums[j] && i <= j-1) {
                continue;
            }

            cur.add(nums[j]);
            backtracking(j + 1, nums, cur);
            cur.removeLast();
        }

    }
}


/*

[1,1,2]
                           esse n precisa processar
            1                      1X                          2
        1      2               
        2

*/
