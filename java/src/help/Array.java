package help;

import java.util.Arrays;

public class Array {

    public static void main(String[] args){

        String s = "bab";
        String t = "abb";

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);

        Arrays.equals(sChar, tChar);
    }
    
}
