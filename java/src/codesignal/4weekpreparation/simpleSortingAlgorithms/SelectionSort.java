package codesignal.simpleSortingAlgorithms;

/*

Definição: seleciona o menor e coloca no começo


You are given an array of integers, and your task is to sort the array using the Selection Sort method. For example, given an array [3, 1, 2, 4, 5], your function should return [1, 2, 3, 4, 5].

Here's an explanation of how Selection Sort works for the example above:

First pass (i = 0): Find the minimum in [3, 1, 2, 4, 5] (which is 1) and swap it with the first element.
Result: [1, 3, 2, 4, 5]

Second pass (i = 1): Find the minimum in [3, 2, 4, 5] (which is 2) and swap it with the second element.
Result: [1, 2, 3, 4, 5]

Third pass (i = 2): Find the minimum in [3, 4, 5] (which is 3); it's already in position.
Result: [1, 2, 3, 4, 5]

Fourth pass (i = 3): Find the minimum in [4, 5] (which is 4); it's already in position.
Result: [1, 2, 3, 4, 5]

Fifth pass (i = 4): Only one element left, no change needed.
Result: [1, 2, 3, 4, 5]

*/

public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            
            int posMin = i;
            
            for (int j = i+1; j < arr.length; j++) {
                
                if (arr[j] < arr[posMin]) {
                    posMin = j;
                }
                
            }
            
            int temp = arr[i];
            arr[i] = arr[posMin];
            arr[posMin] = temp;
            
        }
        
        return arr;
    }
}
