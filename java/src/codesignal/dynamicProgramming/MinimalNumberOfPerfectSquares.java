package codesignal.dynamicProgramming;

import java.util.*;

/*


You are given a positive integer n. Your task is to find the minimal number of perfect squares that sum up to n. A perfect square is an integer that is the square of some other integer. For example, 1, 4, 9, and 16 are perfect squares, but 2 and 3 are not. It is allowed to use the same perfect square multiple times.

For instance, given n equals 13, return 2 because 13 can be expressed as 4 (
2
×
2
2×2) + 9 (
3
×
3
3×3); therefore, the function should return 2 (the number of perfect squares that sum to 13).

The expected time complexity for this algorithm is 
O
(
n
⋅
n
)
O(n⋅ 
n
​
 ).
 */

public class MinimalNumberOfPerfectSquares {

    public static int minNumOfSquares(int n) {
        return minMemo(n, new HashMap<>());
    }
    public static int minMemo(int n, Map<Integer, Integer> map) {
    
        if (n < 1) {
            return 0;
        }
        
        if (map.containsKey(n)){
            return map.get(n);
        }
        
        List<Integer> squares = new ArrayList<>();
        
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        
        int min = n + 1;
        
        for (Integer square : squares) {
            int res =  (n / square) + minMemo(n % square, map);
            
            if (res < min) {
                min = res;
            }
        }
        
        map.put(n, min);
        
        return min;
    }

}


/*

n=12

squares=[9,4,1]


square = 9
n / square = 12 / 9 = 1
n % square = 12 % 9 = 3

calc(3)
n / square = 3 / 1 = 3
n % square = 3 % 1 = 0


res = n / square + calc(n % square);
res = 4


min = 4




square = 4
res = n / square + calc(n % square);
res = 12 / 4 + calc(n % square);


*/