package codesignal;
import java.util.*;

public class MakeArrayConsecutive2 {

    public static int makeArrayConsecutive2(int[] statues) {

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<statues.length; i++) {
            list.add(statues[i]);
        }

        Collections.sort(list);

        int count = 0;
        for(int i=0; i<statues.length-1; i++) {
            count += list.get(i+1) - list.get(i) - 1;
        }

        return count;
    }




    /*
    6, 2, 3, 8


put on arraylist


Collections.sort(list);

get each one seeing the difference from the next



    */

    public static void main(String[] args) {
        runTest(new int[]{6, 2, 3, 8}, 3);
        runTest(new int[]{0, 3}, 2);
        runTest(new int[]{5, 4, 6}, 0);

        // edge cases
        runTest(new int[]{1}, 0);
        runTest(new int[]{1, 10}, 8);
    }

    private static void runTest(int[] input, int expected) {
        int result = makeArrayConsecutive2(input);
        System.out.println(
                Arrays.toString(input) +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}