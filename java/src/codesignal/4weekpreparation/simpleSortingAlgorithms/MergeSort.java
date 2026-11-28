package codesignal.simpleSortingAlgorithms;

/*


You are given an array of n integers. Your task is to implement a merge sort function to sort this array in ascending order and return the sorted array.

Please note that while Java has built-in sorting functionality, the purpose of this task is to practice implementing basic sorting algorithms, so you are not allowed to use Java's built-in sort method. Instead, implement the merge sort algorithm.

Merge Sort is a divide and conquer algorithm. It works by:

Dividing the array into two halves.
Recursively sorting each half.
Merging the sorted halves to produce the sorted array.
Here's an example:

For the array [10, 3, 2, 8, -1, 5, 1]:

Divide into [10, 3, 2] and [8, -1, 5, 1].
Recursively sort each half:
Sort [10, 3, 2] to [2, 3, 10].
Sort [8, -1, 5, 1] to [-1, 1, 5, 8].
Merge [2, 3, 10] and [-1, 1, 5, 8] to get [-1, 1, 2, 3, 5, 8, 10].
The expected time complexity is 
O
(
n
log
⁡
n
)
O(nlogn).

*/

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        
        if (array.length < 2) {
            return array;
        }
        
        int mid = array.length / 2;
        int leftLen = mid;
        int rightLen = mid + array.length % 2;
        
        int[] left = new int[leftLen];
        int[] right = new int[rightLen];
        
        System.arraycopy(array, 0, left, 0, leftLen);
        System.arraycopy(array, mid, right, 0, rightLen);
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        int l = 0, r = 0;
        for (int i = 0; i < array.length; i++) {
            
            if (r == (rightLen) || (l < leftLen && left[l] <= right[r])) {
                array[i] = left[l];
                l++;
            } else {
                array[i] = right[r];
                r++;
            }
            
        }      
        
        return array;
    }
}
