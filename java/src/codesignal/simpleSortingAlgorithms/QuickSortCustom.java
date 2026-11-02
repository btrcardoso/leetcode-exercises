package codesignal.simpleSortingAlgorithms;

import java.util.ArrayList;
import java.util.List;

/*


You are given a list of n integers. Write a Java function that sorts this list using the QuickSort algorithm. Your function should take the list as input and return a sorted list in ascending order without using any built-in sorting functions.

QuickSort is an efficient, comparison-based, divide-and-conquer sorting algorithm. The basic steps are as follows:

Pick a pivot: Choose an element from the array/list to be the pivot (commonly the middle element).
Partitioning: Rearrange the array so that elements less than the pivot come before it, and elements greater than the pivot come after it. Elements equal to the pivot can go either way.
Recursively apply: Apply the same process to the sub-arrays on either side of the pivot.
Here's a quick example with the array [3, 6, 8, 10, 1, 2, 1]:

Choose a pivot: Let's pick the middle element 10.
Partition: Rearrange elements around 10:
Left part: [3, 6, 8, 1, 2, 1]
Pivot: [10]
Right part: []
Apply recursively:
Left part [3, 6, 8, 1, 2, 1] gets partitioned around 8, giving [3, 6, 1, 2, 1], [8], [].
Apply further recursive steps until all sub-arrays have a single element.
For instance, if the provided list is [3, 6, 8, 10, 1, 2, 1], the function should return [1, 1, 2, 3, 6, 8, 10].

The task requires an efficient solution, and the maximum expected time complexity is 
O
(
n
log
⁡
n
)
O(nlogn).
*/

public class QuickSortCustom {
    public static List<Integer> quickSortCustom(List<Integer> arr) {
        
        if (arr.size() == 0) {
            return arr;
        }
        
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        int mid = arr.size() / 2;
        
        for (int i = 0; i < arr.size() ; i++) {
            if (i != mid) {
                Integer val = arr.get(i);
                if (val <= arr.get(mid)) {
                    left.add(val);
                } else {
                    right.add(val);
                }
            }
        }
        
        left = quickSortCustom(left);
        right = quickSortCustom(right);
        
        List<Integer> result = new ArrayList<>(left);
        result.add(arr.get(mid));
        result.addAll(right);
        
        return result;
    }
    
    
    
}
