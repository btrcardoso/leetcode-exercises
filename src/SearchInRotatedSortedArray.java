public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int positionOfBiggest = findPositionOfBiggest(nums);

        int positionOfTarget = binarySearch(nums, 0, positionOfBiggest, target);

        if (positionOfTarget == -1 && positionOfBiggest < nums.length - 1) {
            positionOfTarget = binarySearch(nums, positionOfBiggest + 1, nums.length - 1, target);
        }

        return positionOfTarget;
    }

    public boolean isSorted(int[] nums, int first, int last) {
        return nums[first] <= nums[last];
    }

    public int findPositionOfBiggest(int[] nums) {

        int first = 0;
        int last = nums.length - 1;
        int middle, size;

        while (true) {

            size = last - first + 1;
            middle = first + size / 2;

            if (size <= 2) {
                return nums[first] > nums[last] ? first : last;
            }

            int left = middle - 1;
            int right = middle + 1;

            if (nums[middle] > nums[right]) {
                return middle;
            }

            boolean leftArrayIsSorted = isSorted(nums, first, left);
            boolean rightArrayIsSorted = isSorted(nums, right, last);

            if (leftArrayIsSorted && rightArrayIsSorted) {       // the biggest is in the last position of one of the arrays
                return nums[left] > nums[last] ? left : last;
            } else if (leftArrayIsSorted) {                      // the biggest is in the array of the right
                first = right;
            } else {                                             // the biggest is in the array of the left
                last = left;
            }

        }


    }

    public int binarySearch(int[] nums, int first, int last, int target) {

        int size, middle;

        while (true) {

            size = last - first + 1;
            middle = first + size/2;

            if (last < first) {
                return -1;
            }

            if (nums[middle] > target) {
                last = middle - 1;
            } else if (nums[middle] < target) {
                first = middle + 1;
            } else {
                return middle;
            }

        }

    }
}
