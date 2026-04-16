package codesignal;

import java.util.Arrays;

public class ReverseInParentheses {

    public static String reverseInParentheses(String inputString) {

        while(inputString.contains("(")) {
            int first = inputString.lastIndexOf('(');
            int last = inputString.substring(first).indexOf(')') + first;

            String reverted = reverse(inputString.substring(first+1, last));
            inputString = inputString.substring(0, first) + reverted + inputString.substring(last+1);
        }

        return inputString;
    }

    // receives a string like this abc
    public static String reverse(String subs) {
        return new StringBuilder(subs).reverse().toString();
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
