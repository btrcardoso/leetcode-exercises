package codesignal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PalindromeRearranging {

    /*
    todas as letras tem qtd par -> true
    todas as letras tem qtd par e uma letra é impar -> true
    duas letras tem qtd impar -> false
     */

    public static boolean palindromeRearranging(String inputString) {

        char[] text = inputString.toCharArray();

        Set<Character> set = new HashSet<>();

        for (int i=0; i<text.length; i++) {

            Character ch = text[i];
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }

        }

        return set.size() < 2;
    }

    public static void main(String[] args) {

        runTest("aabb", true);
        runTest("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc", false);
        runTest("abbcabb", true);
        runTest("zzzz", true);
        runTest("abcd", false);
        runTest("aab", true);
        runTest("ab", false);

        // edge cases
        runTest("a", true);
        runTest("aa", true);
        runTest("z", true);

    }

    private static void runTest(String input, boolean expected) {
        boolean result = palindromeRearranging(input);
        System.out.println(
                "\"" + input + "\"" +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}
