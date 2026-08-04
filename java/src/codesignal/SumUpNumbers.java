package codesignal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumUpNumbers {

    public static int sumUpNumbers2(String inputString) {

        int sum = 0;

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(inputString);

        while (m.find()) {
            int num = Integer.parseInt(m.group());
            sum += num;
        }


        return sum;
    }

    public static int sumUpNumbers(String inputString) {

        String[] numbers = inputString.split("[^\\d]");

        int sum = 0;

        for(String num : numbers){
            if(!num.isBlank()) {
                sum += Integer.parseInt(num);
            }
        }


        return sum;
    }

    /*
    scann check -> string

    find the total number of items found
    
    */

    public static void main(String[] args) {
        runTest("2 apples, 12 oranges", 14);
        runTest("123450", 123450);
        runTest("Your payment method is invalid", 0);

        // edge cases
        runTest("", 0);
        runTest("a1b2c3", 6);
    }

    private static void runTest(String input, int expected) {
        int result = sumUpNumbers(input);
        System.out.println(
                "\"" + input + "\"" +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}