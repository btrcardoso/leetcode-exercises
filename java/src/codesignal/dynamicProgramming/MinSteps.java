package codesignal.dynamicProgramming;

import java.util.*;

/*

Given a number, you can perform only two types of operations with it:

Add 1
Multiply by 2
Write a function minSteps(int n) that takes an integer n and computes the minimum number of steps required to transform the number 0 into the number n.

You should solve this task with O(n) time complexity using dynamic programming.

For example, minSteps(8) = 4, because:

Start from 0
Add 1 to get 1 (1 step)
Multiply by 2 to get 2 (1 step)
Multiply by 2 again to get 4 (1 step)
Multiply by 2 one more time to get 8 (1 step)

*/


public class MinSteps {
    
    public static int minSteps(int n) {
        return sequence(n, new HashMap<>());
    }
    
    private static int sequence(int n, Map<Integer, Integer> memo) {
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        if (n < 3) {
            return n;
        }
        
        int res = sequence(n / 2, memo) + 1 + (n % 2);
        
        memo.put(n, res);
        
        return res;
    }
}
