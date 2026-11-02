package codesignal.simpleSortingAlgorithms;

/*
You need to implement the Insertion Sort algorithm. Given an array of n integers, the algorithm must sort the elements of this array in increasing order using Insertion Sort.

The Insertion Sort algorithm iterates over an index from left to right. As the index moves to the right, it "inserts" the element at the index into the correct location in the "already sorted" portion of the array on the left.

Here's an explanation of how Insertion Sort works for an example array [5, 2, 4, 6, 1, 3]:

First pass (i = 1): Insert 2 into the sorted sub-array [5].
We compare 2 with 5 and swap them.
Result: [2, 5, 4, 6, 1, 3]

Second pass (i = 2): Insert 4 into the sorted sub-array [2, 5].
We compare 4 with 5; since 4 is smaller, we shift 5 to the right.
We then compare 4 with 2 and determine its correct position is after 2.
Result: [2, 4, 5, 6, 1, 3]

Third pass (i = 3): Insert 6 into the sorted sub-array [2, 4, 5].
6 is greater than 5, so it remains in its place.
Result: [2, 4, 5, 6, 1, 3]

Fourth pass (i = 4): Insert 1 into the sorted sub-array [2, 4, 5, 6].
We compare 1 with 6, 5, 4, and 2 sequentially, shifting them all to the right.
Finally, insert 1 at the start of the array.
Result: [1, 2, 4, 5, 6, 3]

Fifth pass (i = 5): Insert 3 into the sorted sub-array [1, 2, 4, 5, 6].
We compare 3 with 6, 5, and 4 sequentially, shifting them to the right.
Finally, insert 3 after 2.
Result: [1, 2, 3, 4, 5, 6]




*/

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        
        for (int i = 1; i < arr.length; i++) {
            
            int piv = i;
            
            for (int j = i - 1; j >= 0; j--) {
                
                if (arr[j] > arr[piv]) {
                    
                    int temp = arr[piv];
                    arr[piv] = arr[j];
                    arr[j] = temp;
                    
                    piv = j;
                    
                }
                
            }
            
        }
        
        return arr;
    }
}
