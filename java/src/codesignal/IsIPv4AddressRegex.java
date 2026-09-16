package codesignal;

//https://www.youtube.com/watch?v=IPZjatYCS0U

public class IsIPv4AddressRegex {
    public static boolean isIPv4Address(String inputString) {

        String reg = "^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$";

        

        return inputString.matches(reg);
    }

    /*
    
    255.255.255.255

    ^
    (25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9]){3}\\.
    (25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])
    $
    
    */

    public static void main(String[] args) {
        runTest(".254.255.0", false);
        runTest("172.16.254.1", true);
        runTest("2.2.2.2", true);
        runTest("0.254.255.0", true);
        runTest("10.0.0.1", true);
        runTest("256.1.2.3", false);
        runTest("1.1.1.1.1", false);
        runTest("1.1.1", false);
        runTest("123.456.789.0", false);

        // edge cases
        runTest("01.1.1.1", false);
        runTest("0.0.0.0", true);
        runTest("255.255.255.255", true);
    }

    private static void runTest(String input, boolean expected) {
        boolean result = isIPv4Address(input);
        System.out.println(
                "\"" + input + "\"" +
                        " -> result: " + result +
                        " | expected: " + expected +
                        (result == expected ? " ✅" : " ❌")
        );
    }
}
