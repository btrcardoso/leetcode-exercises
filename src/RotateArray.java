// https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        rotation(nums, 0, nums.length-1);
        rotation(nums, 0, k-1);
        rotation(nums, k, nums.length-1);
    }

    public void rotation(int[] nums, int start, int end) {
        int aux;

        while(start<end) {
            aux = nums[start];
            nums[start] = nums[end];
            nums[end] = aux;

            start++;
            end--;
        }
    }
}


/*
k=3

0,1,2,3,4,5,6
6,5,4,3,2,1,0
4,5,6,0,1,2,3




*/
