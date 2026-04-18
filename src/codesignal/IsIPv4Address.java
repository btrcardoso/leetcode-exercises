package codesignal;

//https://www.youtube.com/watch?v=IPZjatYCS0U

public class IsIPv4Address {
    public static boolean isIPv4Address(String inputString) {

        String[] arr = inputString.split("\\.");

        if(arr.length != 4) return false;

        for (int i = 0; i<4; i++) {

            try {
                int num = Integer.parseInt(arr[i]);

                if(num >= 1 && arr[i].charAt(0) == '0') return false; //leading zero

                if (num>255 || num<0 || arr[i].length()>3) return false;

            } catch (NumberFormatException e) {
                return false;
            }

        }

        return true;
    }

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
