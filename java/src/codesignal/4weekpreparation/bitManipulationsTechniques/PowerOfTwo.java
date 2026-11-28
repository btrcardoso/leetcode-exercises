package codesignal.bitManipulationsTechniques;

/*
You are provided with a positive integer. 
Your task is to write a method solution(int n) that returns true if the number n is a power of 2 and false otherwise. 
You are to solve this problem using only bit manipulation techniques, it is not allowed to use type conversions.

The expected time complexity is $O(1)$.

*/

public class PowerOfTwo {
    public static boolean powerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }
}
