package codesignal.advancedRecursiveFunctions;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        Permutations perm = new Permutations();
        List<List<Integer>> result = perm.permute(new int[]{1, 2, 3});
        System.out.println(result); // Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }

    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] arr) {
        this.result = new ArrayList<>();

        backtracking(arr, new ArrayList<>());

        return this.result;
    }

    public void backtracking(int[] arr, List<Integer> list) {

        if (list.size() == arr.length) {
            this.result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0 ; i < arr.length; i++) {

            if (arr[i] != -1) {

                int temp = arr[i];
                list.add(temp);

                arr[i] = -1;
                backtracking(arr, list);
                arr[i] = temp;

                list.removeLast();

            }

        }


    }

}