package codesignal;
import java.util.*;

/*
🟡 LongestWord — Descrição

Dada uma string text, encontre a palavra mais longa contida nela.

👉 Regras:

Uma palavra é composta apenas por letras (a–z, A–Z)
Qualquer outro caractere (número, espaço, símbolo) quebra a palavra
Se houver empate, retorne a primeira palavra mais longa encontrada
📌 Exemplos
Input: "Ready, steady, go!"
Output: "steady"
Input: "Ready[[[, steady, go!"
Output: "steady"
Input: "ABCd"
Output: "ABCd"
Input: "To be or not to be"
Output: "not"

*/

public class LongestWord {

    public static String longestWord(String text) {

        String[] words = text.split("[^A-Za-z]");

        if(words.length == 0) return "";

        int biggest = 0;
        for (int i=1; i< words.length; i++) {
            if(words[i].length() > words[biggest].length()) {
                biggest = i;
            }
        }


        return words[biggest];
    }

    public static void main(String[] args) {
        runTest("Ready, steady, go!", "steady");
        runTest("Ready[[[, steady, go!", "steady");
        runTest("ABCd", "ABCd");
        runTest("To be or not to be", "not");

        // edge cases
        runTest("123 456", "");
        runTest("", "");
    }

    private static void runTest(String input, String expected) {
        String result = longestWord(input);
        System.out.println(
                "\"" + input + "\"" +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result.equals(expected) ? " ✅" : " ❌")
        );
    }
}