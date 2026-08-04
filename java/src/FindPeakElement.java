//https://leetcode.com/problems/find-peak-element/?envType=problem-list-v2&envId=binary-search
public class FindPeakElement {
    public boolean isLessThan(int[] nums, int i, int j) {

        if (0 <= i && i < nums.length) {
            return nums[i] < nums[j];
        }

        return true;
    }

    public int find(int[] nums, int first, int last) {
        if (last < first) return -1;

        int mid = (first + last) / 2;

        boolean leftIsLess = isLessThan(nums, mid - 1, mid);
        boolean rightIsLess = isLessThan(nums, mid + 1, mid);

        if (leftIsLess && rightIsLess) {
            return mid;
        }

        int lastForLeft = mid - 1;
        int firstForRight = mid + 1;

        if (rightIsLess) {
            firstForRight++;
        }

        if (leftIsLess) {
            lastForLeft--;
        }

        int leftVectorResult = find(nums, first, lastForLeft);
        if (leftVectorResult > -1) return leftVectorResult;

        int rightVectorResult = find(nums, firstForRight, last);
        if (rightVectorResult > -1) return rightVectorResult;

        return -1;
    }

    public int findPeakElement(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
}
