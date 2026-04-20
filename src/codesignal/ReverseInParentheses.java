package codesignal;
import java.util.*;

//https://www.youtube.com/watch?v=jFZZTScWM44&t=4s

public class ReverseInParentheses {

    public static String reverseInParentheses(String inputString) {

        int lastOpen = inputString.lastIndexOf("(");

        while (lastOpen > -1) {
            int firstClose = inputString.indexOf(")", lastOpen);

            String part = inputString.substring(lastOpen+1, firstClose);

            StringBuilder reverted = new StringBuilder(part).reverse();

            inputString = inputString.substring(0, lastOpen) + reverted + inputString.substring(firstClose+1, inputString.length());

            lastOpen = inputString.lastIndexOf("(");
        }

        return inputString;
    }


    public static void main(String[] args) {

        runTest("(bar)", "rab");
        runTest("foo(bar)baz", "foorabbaz");
        runTest("(foo(bar))", "baroof");
        runTest("foo(bar(baz))blim", "foobazrabblim");
        runTest("abcd", "abcd");
        runTest("a(bc)de", "acbde");
        runTest("a(bc)de(fg)", "acbdegf");

        // edge cases
        runTest("", "");
        runTest("(a)", "a");
        runTest("(abcd)", "dcba");

    }

    private static void runTest(String input, String expected) {
        String result = reverseInParentheses(input);
        System.out.println(
                "\"" + input + "\"" +
                        " -> result: \"" + result + "\"" +
                        " | expected: \"" + expected + "\"" +
                        (result.equals(expected) ? " ✅" : " ❌")
        );
    }
}
