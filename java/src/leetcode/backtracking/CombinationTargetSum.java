package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://neetcode.io/problems/combination-target-sum/solution

public class CombinationTargetSum {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    int target;

    public void dfs (int i, int sum, List<Integer> list) {
        if (sum + nums[i] > target) {
            return;
        }

        list.add(nums[i]);

        if (sum + nums[i] < target) {
            for (int j = i ; j < nums.length; j++) {
                if (nums[j] + sum + nums[i] > target) {
                    break;
                }
                dfs(j, sum + nums[i], list);
            }

        } else {
            result.add(new ArrayList<>(list));
        }

        list.remove(list.size() - 1);

    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        Arrays.sort(this.nums);

        for (int i = 0 ; i < this.nums.length; i++) {
            dfs(i, 0, new ArrayList<>());
        }

        return result;

    }
}
