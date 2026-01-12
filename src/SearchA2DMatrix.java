//https://leetcode.com/problems/search-a-2d-matrix/?envType=problem-list-v2&envId=binary-search

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int first = 0;
        int last = matrix.length - 1;
        int middle, size;
        int firstColumn, lastColumn;

        while (first <= last) {

            size = last - first + 1;
            middle = first + size/2;

            if (size == 1) {
                return binarySearch(matrix[middle], target);
            }

            firstColumn = matrix[middle][0];
            lastColumn = matrix[middle][matrix[middle].length - 1];

            if (firstColumn == target) {
                return true;
            }

            if (target < firstColumn) {                                 // the previous row will be the last
                last = middle - 1;
            } else if (firstColumn < target && target <= lastColumn) {  // it's in this row
                return binarySearch(matrix[middle], target);
            } else {                                                    // the next row will be the first
                first = middle + 1;
            }

        }

        return false;

    }

    public boolean binarySearch(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int middle, size;

        while (first <= last) {

            size = last - first + 1;
            middle = first + size/2;

            if (nums[middle] == target) {
                return true;
            }

            if (target < nums[middle]) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }

        }

        return false;


    }

}
