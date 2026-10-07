package hackerhank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface LambdaExpressionInterface{
    String operation(int val);
}

class Help {
    
    LambdaExpressionInterface checkEvenOdd() {
        return val -> val % 2 == 0 ? "EVEN" : "ODD";
    }
    
    LambdaExpressionInterface checkPrime() {
        return val -> {
            
            if (val < 2) {
                return "COMPOSITE";
            }
            
            for (int i = 2; i < val; i ++) {
                if (val % i == 0) {
                    return "COMPOSITE";
                }
            }
            
            return "PRIME";
        };
    }
    
    LambdaExpressionInterface checkPalindrome() {
        return val -> {
            String str = Integer.toString(val);
            
            String reversed = new StringBuilder(str).reverse().toString();
            
            return str.equals(reversed) ? "PALINDROME" : "NOT PALINDROME";
        };
    }

}

public class JavaLambdaExpressions {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String[] results = new String[n];
        Help help = new Help();
        
        for (int i = 0; i < n ; i++) {
            int code = sc.nextInt();
            int num = sc.nextInt();
            
            LambdaExpressionInterface action = help.checkEvenOdd();
            if (code == 2) {
                action = help.checkPrime();
            } else if (code == 3) {
                action = help.checkPalindrome();
            } 
            
            results[i] = action.operation(num);
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(results[i]);
        }
        
    }
}
