package codesignal;

import java.util.HashMap;
import java.util.Map;

public class CommonCharacterCount {

    public static int commonCharacterCount(String s1, String s2) {
        int count = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Character c;

        // adiciona a quantidade de letras da string1 no mapa
        char[] c1 = s1.toCharArray();
        for (int i=0; i<c1.length; i++) {
            c = c1[i];

            Integer val = 1;
            if (map1.containsKey(c)) {
                val += map1.get(c);
            }
            map1.put(c, val);

        }

        // remove do mapa as letras conforme for encontrando na string2 e conta+1
        char[] c2 = s2.toCharArray();
        Integer qt;
        for (int i=0; i<c2.length; i++) {
            c = c2[i];

            if (map1.containsKey(c)) {
                count++;
                qt = map1.get(c);

                if (qt == 1) {
                    map1.remove(c);
                } else {
                    map1.put(c, qt-1);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        runTest("aabcc", "adcaa", 3);
        runTest("zzzz", "zzzzzzz", 4);
        runTest("abca", "xyzbac", 3);
        runTest("a", "b", 0);
        runTest("a", "a", 1);
        runTest("abcdef", "fedcba", 6);
        runTest("xyz", "abc", 0);
        runTest("aaa", "aa", 2);

        // edge cases
        runTest("a", "aaaaaa", 1);
        runTest("zzz", "z", 1);

    }

    private static void runTest(String s1, String s2, int expected) {
        int result = commonCharacterCount(s1, s2);
        System.out.println(
                "\"" + s1 + "\", \"" + s2 + "\"" +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}
