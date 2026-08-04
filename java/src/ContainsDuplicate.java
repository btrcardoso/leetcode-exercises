// https://leetcode.com/problems/contains-duplicate/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> map = new HashSet<>();

        for (int i = 0; i<nums.length; i++) {
            if (!map.add(nums[i])) {
                return true;
            }
        }

        return false;

    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean containsDuplicate2(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
