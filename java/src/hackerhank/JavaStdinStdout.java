package hackerhank;

import java.util.Scanner;

public class JavaStdinStdout {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        
        double d = scan.nextDouble();
        
        scan.nextLine(); // consume \n

        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }


    /*
    
Sample Input:

42
3.1415
Welcome to HackerRank's Java tutorials!
Sample Output

Sample Output:

String: Welcome to HackerRank's Java tutorials!
Double: 3.1415
Int: 42
    
    */
}
