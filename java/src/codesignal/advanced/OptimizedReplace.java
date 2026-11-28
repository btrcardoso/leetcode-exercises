package codesignal.advanced;

/*
https://codesignal.com/learn/course/351/unit/1/practice/3

You are given two arrays, array A and array B, each containing n integers where n can range from 
2
2 to 
100000
100000, inclusive. All elements of both arrays are integers that can range from 
−
10
10
−10 
10
  to 
10
10
10 
10
 , inclusive.

Your task is to create a function optimizedReplace that returns a new array, C. For each index i, C[i] should contain a specific value from array A - A[j], determined by the condition that B[i] is the closest number to B[j] from array B.

This means that array C will have the same length as A and B. C[i] will contain the value corresponding to the j-th index from array A, where the value at the j-th index in array B is closest to the value at the i-th index of array B.

Assume that there is no ambiguity. The array B is given in a way that no two elements in array B have the same minimal absolute difference with B[i].

Remember, the number of elements, n, and the range of the elements, imply that brute force solutions will not be efficient. You should aim to leverage optimized algorithms and techniques to solve this task efficiently.

Example

Suppose we have A = {10, 20, 30, 40, 50} and B = {7, 5, 1, 2, 4}.

The function optimizedReplace(A, B) should work as follows:

For B[0] = 7, the closest number in B is 5 at index 1. Hence, C[0] = A[1] = 20.

For B[1] = 5, the closest number in B is 4 at index 4. Thus, C[1] = A[4] = 50.

For B[2] = 1, the closest number in B is 2 at index 3. Hence, C[2] = A[3] = 40.

For B[3] = 2, the closest number in B is 1 at index 2. So, C[3] = A[2] = 30.

Lastly, for B[4] = 4, the closest number in B is 5 at index 1. We have C[4] = A[1] = 20.

Thus, the function optimizedReplace({10, 20, 30, 40, 50}, {7, 5, 1, 2, 4}) should return {20, 50, 40, 30, 20}.


*/

import java.util.*;

public class OptimizedReplace {
    public long[] optimizedReplace(long[] A, long[] B) {

        int n = B.length;

        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(i, B[i]);
        }

        Arrays.sort(pairs, Comparator.comparingLong(p -> p.val));

        long[] C = new long[n];

        for (int i = 0; i < n; i++) {
            
            int curIdx = pairs[i].i;
            long curVal = pairs[i].val;

            Pair previous = i > 0 ? pairs[i - 1] : null;
            Pair next = i < n - 1 ? pairs[i + 1] : null;
            Pair chosen = pairs[i];

            if (previous != null && next != null) {
                long distPrevious = Math.abs(previous.val - curVal);
                long distNext = Math.abs(next.val - curVal);

                chosen = distNext < distPrevious ? next : previous;
                
            } else if (next != null) {
                chosen = next;
            } else if (previous != null) {
                chosen = previous;
            }

            C[curIdx] = A[chosen.i];
            
        }

        return C;
    }

    class Pair{
        int i;
        long val;

        Pair(int i, long val) {
            this.i = i;
            this.val = val;
        }
    }
}


/*
B = {(0)7, (1)5, (2)1, (3)2, (4)4}
A = {10, 20, 30, 40, 50}


BOrd = {(2)1, (3)2, (4)4, (1)5, (0)7}


C = {0=, 1=, 2=A[3], 3=A[2], 4=}



*/