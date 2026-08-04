package codesignal;
import java.util.*;
/*
biggestPos = 2
biggest = 190


find backwards the available one
lastAvailable = 7

                                    
-1, 150, 190, 170, -1, -1, 160, 180

*/

public class SortByHeight {

    public static int[] sortByHeight(int[] a) {

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<a.length;i++){
            if (a[i] != -1) {
                list.add(a[i]);
            }
        }

        Collections.sort(list);

        int idx = 0;
        for (int i=0; i<a.length;i++) {
            if (a[i] != -1) {
                a[i] = list.get(idx);
                idx++;
            }
        }
    

        return a;
    }

















    public static void main(String[] args) {
        runTest(new int[]{-1, 150, 190, 170, -1, -1, 160, 180},
                new int[]{-1, 150, 160, 170, -1, -1, 180, 190});

        runTest(new int[]{-1, -1, -1}, new int[]{-1, -1, -1});
        runTest(new int[]{4, 2, 9, 11, 2, 16},
                new int[]{2, 2, 4, 9, 11, 16});

        // edge cases
        runTest(new int[]{1}, new int[]{1});
    }

    private static void runTest(int[] input, int[] expected) {
        int[] result = sortByHeight(input);
        System.out.println(
                Arrays.toString(input) +
                        " -> result: " + Arrays.toString(result) +
                        " | expected: " + Arrays.toString(expected) +
                        (Arrays.equals(result, expected) ? " ✅" : " ❌")
        );
    }








    public static void mostra(int[] a){
        for(int x=0; x<a.length; x++){
            System.out.print(a[x] + " ");
        }
        System.out.println(" ");
    }
}