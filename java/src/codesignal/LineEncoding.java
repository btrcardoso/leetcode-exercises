package codesignal;
import java.util.*;

// https://www.youtube.com/watch?v=C5gqyKWyNQI

public class LineEncoding {

    public static String lineEncoding(String s) {

        StringBuilder sb = new StringBuilder();

        char[] c = s.toCharArray();

        char previous = c[0];
        int count = 1;

        for(int i=1; i<=c.length; i++) {

            if (i<c.length && c[i] == previous) {
                count ++;
            } else {
                String str = (count == 1 ? "": count) + "" + previous;
                sb.append(str);

                if (i<c.length) {
                    previous = c[i];
                    count = 1;
                }
            }

        }

        return sb.toString();


    }

    public static void main(String[] args) {
        runTest("aabbbc", "2a3bc");
        runTest("abbcabb", "a2bca2b");
        runTest("abcd", "abcd");

        // edge cases
        runTest("zzzz", "4z");
        runTest("a", "a");
    }

    private static void runTest(String input, String expected) {
        String result = lineEncoding(input);
        System.out.println(
                "\"" + input + "\"" +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result.equals(expected) ? " ✅" : " ❌")
        );
    }
}
