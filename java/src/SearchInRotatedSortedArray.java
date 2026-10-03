public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) { // left array + mid is sorted

                if (nums[l] <= target && target < nums[mid]) {  // target is in left array
                    r = mid - 1; // go to left array
                } else {
                    l = mid + 1; // go to right array
                }

            } else { // left array + mid is not sorted, then right array is sorted

                if (nums[mid] < target && target <= nums[r]) { // target is in right array
                    l = mid + 1; // go to right array
                } else {
                    r = mid - 1; // go to left array
                }

            }

        }

        return -1;
        
    }



    public boolean arrayIsSorted(int[] nums, int first, int last) {
        return nums[first] <= nums[last];
    }

    public boolean targetIsInsideTheSortedArray(int[] nums, int first, int last, int target){
        return nums[first] <= target && target <= nums[last];
    }

    public int search_(int[] nums, int target) {

        int first = 0;
        int last = nums.length - 1;
        int size, middle;

        while (true) {

            size = last - first + 1;
            middle = first + size/2;

            if (size <= 2) {
                return nums[first] == target ? first : (nums[last] == target ? last : -1);
            }

            if (nums[middle] == target) {
                return middle;
            }

            int left = middle - 1;
            int right = middle + 1;

            boolean leftArrayIsSorted = arrayIsSorted(nums, first, left);
            boolean rightArrayIsSorted = arrayIsSorted(nums, right, last);

            if (leftArrayIsSorted && rightArrayIsSorted) {

                if (targetIsInsideTheSortedArray(nums, first, left, target)) {        // target is inside the left
                    last = left;
                } else if (targetIsInsideTheSortedArray(nums, right, last, target)) { // target is inside the right
                    first = right;
                } else {                                                              // target is not in any array
                    return -1;
                }

            } else if (leftArrayIsSorted) {

                if (targetIsInsideTheSortedArray(nums, first, left, target)) {        // target is inside the sorted left array
                    last = left;
                } else {                                                              // target is inside the unsorted right array
                    first = right;
                }

            } else if (rightArrayIsSorted) {

                if (targetIsInsideTheSortedArray(nums, right, last, target)) {        // target is inside the sorted right array
                    first = right;
                } else {                                                              // target is inside the unsorted left array
                    last = left;
                }

            }


        }
    }


    // FIRST TRY
//    public int search(int[] nums, int target) {
//        int positionOfBiggest = findPositionOfBiggest(nums);
//
//        int positionOfTarget = binarySearch(nums, 0, positionOfBiggest, target);
//
//        if (positionOfTarget == -1 && positionOfBiggest < nums.length - 1) {
//            positionOfTarget = binarySearch(nums, positionOfBiggest + 1, nums.length - 1, target);
//        }
//
//        return positionOfTarget;
//    }
//
//    public boolean isSorted(int[] nums, int first, int last) {
//        return nums[first] <= nums[last];
//    }
//
//    public int findPositionOfBiggest(int[] nums) {
//
//        int first = 0;
//        int last = nums.length - 1;
//        int middle, size;
//
//        while (true) {
//
//            size = last - first + 1;
//            middle = first + size / 2;
//
//            if (size <= 2) {
//                return nums[first] > nums[last] ? first : last;
//            }
//
//            int left = middle - 1;
//            int right = middle + 1;
//
//            if (nums[middle] > nums[right]) {
//                return middle;
//            }
//
//            boolean leftArrayIsSorted = isSorted(nums, first, left);
//            boolean rightArrayIsSorted = isSorted(nums, right, last);
//
//            if (leftArrayIsSorted && rightArrayIsSorted) {       // the biggest is in the last position of one of the arrays
//                return nums[left] > nums[last] ? left : last;
//            } else if (leftArrayIsSorted) {                      // the biggest is in the array of the right
//                first = right;
//            } else {                                             // the biggest is in the array of the left
//                last = left;
//            }
//
//        }
//
//
//    }
//
//    public int binarySearch(int[] nums, int first, int last, int target) {
//
//        int size, middle;
//
//        while (true) {
//
//            size = last - first + 1;
//            middle = first + size/2;
//
//            if (last < first) {
//                return -1;
//            }
//
//            if (nums[middle] > target) {
//                last = middle - 1;
//            } else if (nums[middle] < target) {
//                first = middle + 1;
//            } else {
//                return middle;
//            }
//
//        }
//
//    }
}
