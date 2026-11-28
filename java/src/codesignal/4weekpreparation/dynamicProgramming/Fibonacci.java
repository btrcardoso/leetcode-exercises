package codesignal.dynamicProgramming;

import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(10, new HashMap<Integer, Integer>())); // Output: 55
    }

    public static int fibonacci(int n, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n <= 1) {
            return n;
        }
        int result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        memo.put(n, result);
        return result;
    }
}
