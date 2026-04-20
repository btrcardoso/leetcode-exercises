package codesignal;

import java.util.*;

//https://www.youtube.com/watch?v=uw_cHJ5Ednw

public class PalindromeRearranging {

    /*
    todas as letras tem qtd par -> true
    todas as letras tem qtd par e uma letra é impar -> true
    duas letras tem qtd impar -> false
     */

    public static boolean palindromeRearranging(String inputString) {

        Set<Character> elements = new HashSet<>();

        for(int i=0; i<inputString.length(); i++) {

            Character ch = inputString.charAt(i);

            if (!elements.add(ch)) {
                elements.remove(ch);
            }

        }

        return elements.size() < 2;

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
