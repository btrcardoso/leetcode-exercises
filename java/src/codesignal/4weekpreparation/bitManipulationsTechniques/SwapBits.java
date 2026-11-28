package codesignal.bitManipulationsTechniques;

public class SwapBits {
    public static int swapBits(int n) {
        return ((n & 0x55555555) << 1) | ((n & 0xAAAAAAAA) >> 1);
    }
}



/*


              54321
              
original      10111
maskOdd    01010101 (0x55555555)
resultOdd  00010101

original      10111
maskEven   10101010 (0xAAAAAAAA)
resultEven 00000010




resultOdd     00010101
resultEven    00000010

resultOddLeftShifted      00101010
resultEvenRightShifted    00000001
                            101011
                                                  


 


             

*/