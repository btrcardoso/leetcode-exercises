package codesignal.simpleSortingAlgorithms;

import java.util.Arrays;

public class QuickSort {

    // Main method to test the algorithm
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:   " + Arrays.toString(arr));
    }

    /**
     * The main QuickSort function that implements recursion.
     * @param arr   The array to be sorted
     * @param low   Starting index
     * @param high  Ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is the partitioning index, arr[pi] is now at the correct position
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after the partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * This function takes the last element as a pivot, places the pivot element 
     * at its correct position in the sorted array, and places all smaller elements 
     * to the left of the pivot and all greater elements to the right.
     */
    private static int partition(int[] arr, int low, int high) {
        // Choosing the last element as the pivot
        int pivot = arr[high]; 
        
        // Index of the smaller element; indicates the right position of pivot found so far
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            // If the current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // Swap the pivot element with the element at i + 1 so that the pivot
        // sits securely between smaller and larger elements
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Utility function to swap two elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

