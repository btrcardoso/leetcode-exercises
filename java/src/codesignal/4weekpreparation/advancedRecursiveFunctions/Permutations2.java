package codesignal.advancedRecursiveFunctions;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

     public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3})); // Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }


    public static List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        backtracking(nums, 0, result);

        return result;
    }

    private static void backtracking(int[] nums, int first, List<List<Integer>> result) {

        if (first == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums){
                list.add(num);
            }
            result.add(list);
        }

        for(int i = first; i < nums.length; i++) {
            swap(nums, first, i);
            backtracking(nums, first + 1, result);
            swap(nums, first, i);
        }

    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}



/*
                  [123]
0    [123]        [213]        [321]    
1  [123][132]   [213][231]   [321][312]






*/
