package codesignal.advancedArrayManipulationsTechniques;

/*

You are given an array of n integers. Write a function that rearranges the array so that the middle half of the elements (considering the left and right quarters have been eliminated) move to the beginning of the array. The remaining elements, the left and right quarters, should move to the end of the array. If n is not divisible by 4, include the extra elements in the middle half.

Specifically:

Divide the array into four quarters.
Move the second and third quarters to the front in that order.
Move the first and fourth quarters to the back in that order.
The function should modify the array in place.

For example, if the input array is [1, 2, 3, 4, 5, 6, 7, 8], your function should rearrange the array to [3, 4, 5, 6, 1, 2, 7, 8].

The solution should have a time complexity of $O(n)$.

*/

public class RearrangeArray {
     public void rearrangeArray(int[] nums) {
        
        int len = nums.length / 4 ;
        
        reverse(nums, 0, nums.length - len - 1);
        
        reverse(nums, 0, nums.length - 2*len - 1);
        reverse(nums, nums.length - 2*len, nums.length - len - 1);
        
    }
    
    
    private void reverse(int[] nums, int l, int r) {
        
        while (l < r) {
            
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            
            l++;
            r--;
            
        }
        
    }
}


/*

[0, 1, 2, 3, 4, 5, 6, 7]

[0, 1, 2, 3, 4, 5, 6, 7, 8]

[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]



9 / 4 = 2

11/4 = 2




*/