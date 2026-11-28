package codesignal.bitManipulationsTechniques;

// Contar a quantidade de bits 1 em um número

public class BitManipulation {

    public static void main(String[] args) {
        //System.out.println(countSetBits(6));

        System.out.println(findLoneSetBit(2));
    }

    public static int countSetBits(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n-1);
            count++;
        }

        return count;
    }

    /*
    Write a function findLoneSetBit(int n) which returns the position of the only set bit (bit having value 1) 
    in the binary representation of a given non-zero integer n. If there are multiple or no set bits in the given number, return -1.
    The solution is allowed to use only bit techniques, it is not allowed to use type conversions.

    System.out.println(Solution.findLoneSetBit(16));  // Output: 5 (16 = 10000)
    System.out.println(Solution.findLoneSetBit(13));  // Output: -1 (13 = 1101)
    System.out.println(Solution.findLoneSetBit(0));   // Output: -1 (0 = 0)
    */
    public static int findLoneSetBit(int n) {
        if (n != 0 && (n & (n-1)) == 0) { // non-zero, power of two
        
            int pos = 0;
        
            while (n != 0) {
                n = n >>> 1; // shifting right    100 >>> 010 >>> 001 >>> 000
                pos++;
            }
        
            return pos;
        }
        return -1; 
    }

    /*
    
    Your task is to write a Java function named countUnsetBits. 
    This function will take a 32-bit integer n as input and return the number of unset (0) bits in the binary representation of the given number.
    The solution is allowed to use only bit techniques, it is not allowed to use type conversions.
    
    */
    public static int countUnsetBits(int n) {
        
        int count = 0;
        
        // count setBits
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        
        return 32 - count;
    }


    /*
    You are to write a function getBitDiff(a, b) that calculates the count of different bits between two integers a and b. This function should return an integer representing the number of positions at which the corresponding bits are different.

For example, if a = 14 (1110) and b = 15 (1111), the function getBitDiff(a, b) should return 1, as it is only one bit different in the binary representation of a and b.

You can only use bit manipulation in this task, type conversion is not allowed.
    
    */
    public static int getBitDiff(int a, int b) {
        int diff = a ^ b; // ou exclusivo
        
        int count = 0;
        
        while (diff != 0) {
            diff = diff & (diff - 1);
            count ++;
        }
        
        return count;
    }
    
}


/*

0 =  000
1 =  001
2 =  010
3 =  011
4 =  100
5 =  101
6 =  110
7 =  111
8 = 1000


110(6) & 101(5) = 100(4)
100(4) &  11(3) =   0(0)
possui 2 1s


1000(8) & 111(7) = 0(0)
possui 1 1s


111(7) & 110(6) = 110(6)
110(6) & 101(5) = 100(4)
100(4) &  11(3) =   0(0)
possui 3 1s

*/