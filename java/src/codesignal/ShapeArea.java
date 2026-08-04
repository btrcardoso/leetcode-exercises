package codesignal;
import java.util.*;

// https://www.youtube.com/watch?v=KlUguAhjVPE

public class ShapeArea {

    public static int shapeArea(int n) {

        if(n==1) return 1;

        return 4 + (n-2) * 4  + shapeArea(n-1);

    }

    /*
    

    
    */




















    public static void main(String[] args) {
        runTest(2, 5);
        runTest(3, 13);
        runTest(1, 1);

        // edge cases
        runTest(4, 25);
        runTest(5, 41);
    }

    private static void runTest(int input, int expected) {
        int result = shapeArea(input);
        System.out.println(
                input +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}