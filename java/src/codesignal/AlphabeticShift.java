package codesignal;

import java.util.*;

//https://www.youtube.com/watch?v=xQihiIHRMo8

public class AlphabeticShift {
    public static String alphabeticShift(String inputString) {

        StringBuilder sb = new StringBuilder();

        char[] chars = inputString.toCharArray();

        for (char ch : chars) {
            char newCharacter = (char) (ch+1);

            if(ch == 'z') newCharacter = 'a';
            if(ch == 'Z') newCharacter = 'A';

            sb.append(newCharacter);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        runTest("crazy", "dsbaz");
        runTest("z", "a");
        runTest("abc", "bcd");
        runTest("zbcd", "acde");
        runTest("zzz", "aaa");
        runTest("a", "b");

        // edge cases
        runTest("az", "ba");
        runTest("zzzz", "aaaa");
    }

    private static void runTest(String input, String expected) {
        String result = alphabeticShift(input);
        System.out.println(
                "\"" + input + "\"" +
                        " -> result: \"" + result + "\"" +
                        " | expected: \"" + expected + "\"" +
                        (result.equals(expected) ? " ✅" : " ❌")
        );
    }
}
