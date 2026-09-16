package help;

import java.util.*;
import java.io.*;



class LearningScanner{
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if (x>=-128 && x<=127)System.out.println("* byte");
                if (x >= Short.MIN_VALUE && x<= Short.MAX_VALUE) System.out.println("* short");
                if (x >= Integer.MIN_VALUE && x<= Integer.MAX_VALUE) System.out.println("* int");
                if (x >= Long.MIN_VALUE && x<= Long.MAX_VALUE) System.out.println("* long");
                if (x> Long.MAX_VALUE) throw new Exception();
                
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }

    // https://www.hackerrank.com/challenges/java-end-of-file/problem?isFullScreen=true
    public static void EOF() {
        Scanner sc = new Scanner(System.in);
        
        List<String> list = new ArrayList<>();
        
        do { 
            String str = sc.nextLine();
            list.add(str);
        } while (sc.hasNext());
        
        
        for(int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + " " + list.get(i));
        }
    }



}