package hackerhank;

public class JavaSubstringComparisons {
    // Lexicographical Order
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        for (int i = 0; i <= s.length() - k ; i++) {
            
            String cur = s.substring(i, i+k);
            
            if (cur.compareTo(smallest) < 0 || smallest.equals("")) {
                smallest = cur;
            }
            
            if (cur.compareTo(largest) > 0) {
                largest = cur;
            }
            
        }
        
        return smallest + "\n" + largest;
    }
}
