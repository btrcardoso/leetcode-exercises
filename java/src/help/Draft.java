package help;

import java.util.*;

public class Draft {


    public final static char WORD_SEP = '.';

    public static void main(String[] args) {
        
        /*
        
        byte[] asciiBytes = "abc_".getBytes();

        System.out.println(asciiBytes[0]);


        int val = Integer.valueOf("");
        char valChar = (char) val;
        System.out.println(valChar);
        */

        String str = "www";
        String[] splitted = str.split("w");
        System.out.println(splitted.length);




    }

}


