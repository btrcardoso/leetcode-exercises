package leetcode.backtracking;

import java.util.*;

public class Subsets {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtrack(0, new ArrayList<>());
        return list;
    }

    private void backtrack(int i, List<Integer> cur) {

        if (i == nums.length) {
            list.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(i + 1, cur);
        cur.remove(cur.size() - 1);
        backtrack(i + 1, cur);

    }
}


/* 

0                           .
1                [1]                   []
2        [1,2]         [1]       [2]        []
3  [1,2,3]   [1,2] [1,3] [1] [2,3] [2]    [3][]
4 

*/