package codesignal.stringSearchingAlgorithmsInJava;

import java.util.Arrays;

public class LongestProperPrefixWhichIsAlsoSufix {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(computeLPSArray("ABAAABA")));
    }
    
    /*
        [A,B,A,C,A,B,A]         [A,B,A,A,A,B,A]
        [0,0,1,0,1,2,3]         [0,0,1,1,1,2,3]        
        
        Aramazena o tamanho do maior prefixo (que também é sufixo) até aquele ponto
    */
    private static int[] computeLPSArray(String pattern) {
        int l = 0; // last element of prefix / length of prefix
        int r = 1; // current position of the sufix

        int[] lps = new int[pattern.length()]; // longest proper prefix which is also a suffix
        lps[0] = 0;

        while (r < pattern.length()) {

            if (pattern.charAt(r) == pattern.charAt(l)) { // case1
                l++;
                lps[r] = l;
                r++;

            } else if (l != 0) {  // case2
                l = lps[l - 1];
                 
            } else {              // case3
                lps[r] = 0;
                r++;
            }

        }

        return lps;
    }
    /*

  
l r
A,B,A,C,A,B,A   lps=[0,0,0,0,0,0,0] case3


l   r
A,B,A,C,A,B,A   lps=[0,0,0,0,0,0,0] case1
  l r
A,B,A,C,A,B,A   lps=[0,0,1,0,0,0,0]

      
  l   r
A,B,A,C,A,B,A   lps=[0,0,1,0,0,0,0] case2

    
l       r
A,B,A,C,A,B,A   lps=[0,0,1,0,0,0,0] case1     
  l     r
A,B,A,C,A,B,A   lps=[0,0,1,0,1,0,0]

          
  l       r
A,B,A,C,A,B,A   lps=[0,0,1,0,1,0,0] case1       
    l     r
A,B,A,C,A,B,A   lps=[0,0,1,0,1,2,0]

            
    l       r
A,B,A,C,A,B,A   lps=[0,0,1,0,1,2,0] case1         
      l     r
A,B,A,C,A,B,A   lps=[0,0,1,0,1,2,3] 



    */

    
}

