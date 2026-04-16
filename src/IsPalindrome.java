public class IsPalindrome {
    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] arr = s.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
