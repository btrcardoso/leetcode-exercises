package codesignal;

import java.util.Arrays;

public class AddBorder {

    public static String[] addBorder(String[] picture) {

        if (picture[0].isEmpty()) return new String[]{};

        String[] newPicture = new String[picture.length + 2];
        int borderLen = picture[0].length() + 2;

        newPicture[0] = "*".repeat(borderLen);
        int i;
        for (i=0; i<picture.length; i++) {
            newPicture[i+1] = "*" + picture[i] + "*";
        }
        newPicture[i+1] = "*".repeat(borderLen);

        return newPicture;
    }


























    public static void main(String[] args) {

        runTest(
                new String[]{"abc", "ded"},
                new String[]{"*****", "*abc*", "*ded*", "*****"}
        );
        runTest(
                new String[]{"a"},
                new String[]{"***", "*a*", "***"}
        );
        runTest(
                new String[]{"hello", "world"},
                new String[]{"*******", "*hello*", "*world*", "*******"}
        );

        // edge cases
        runTest(
                new String[]{"x"},
                new String[]{"***", "*x*", "***"}
        );
        runTest(
                new String[]{"ab", "cd"},
                new String[]{"****", "*ab*", "*cd*", "****"}
        );

    }

    private static void runTest(String[] input, String[] expected) {
        String[] result = addBorder(input.clone());
        System.out.println(
                Arrays.toString(input) +
                        " -> result: " + Arrays.toString(result) +
                        " | expected: " + Arrays.toString(expected) +
                        (Arrays.equals(result, expected) ? " ✅" : " ❌")
        );
    }
}
