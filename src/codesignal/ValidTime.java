package codesignal;

import java.util.*;

// https://www.youtube.com/watch?v=HA3QhdCWisQ

public class ValidTime {

    public static boolean validTime(String time) {

        String[] times = time.split(":");

        if(times.length != 2) return false;

        if(times[0].isBlank() || times[1].isBlank()) return false;

        try {
            int hour = Integer.parseInt(times[0]);
            if(hour > 23 || hour < 0) return false;

            int min = Integer.parseInt(times[1]);
            if(min > 59 || min < 0) return false;
        } catch (NumberFormatException e) {
            return false;
        }

        return true;

    }

    public static void main(String[] args) {
        runTest("13:58", true);
        runTest("25:51", false);
        runTest("02:76", false);

        // edge cases
        runTest("00:00", true);
        runTest("23:59", true);
        runTest("24:00", false);
    }

    private static void runTest(String input, boolean expected) {
        boolean result = validTime(input);
        System.out.println(
                "\"" + input + "\"" +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}