package help;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

//https://www.hackerrank.com/challenges/java-bigdecimal/problem?isFullScreen=true

public class LearningComparator {
    public static void main(String []args) {
        
        String[] s = new String[]{"9","-100","50","0","56.6","90","0.12",".12","02.34","000.000"};
        
        Arrays.sort(s, new Comparator<Object>() {
    
            public int compare(Object a1, Object a2) {

                BigDecimal bigDec1 = new BigDecimal((String)a1);
                BigDecimal bigDec2 = new BigDecimal((String)a2);
                
                return bigDec2.compareTo(bigDec1);
            }
            
        });

        for(int i=0;i<s.length;i++)
        {
            System.out.println(s[i]);
        }
    }
}
