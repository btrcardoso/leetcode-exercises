package codesignal;

public class Palindrome {
    public boolean isPalindrome(String inputString) {
        
        int l = 0, r = inputString.length() - 1; 
        
        while (l<=r) {
            
            char left = inputString.charAt(l);
            char right = inputString.charAt(r);
            
            if (isSameLetter(left, right)) {
                l++;
                r--;
            } else if (!isLetter(left)) {
                l++;
            } else if (!isLetter(right)) {
                r--;
            } else {
                return false;
            }         
            
        }
        
        return true;
    }
    
    private boolean isLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
    
    private boolean isSameLetter(char left, char right) {
        
        if (isLetter(left) && isLetter(right)) {
            return left == right || Math.abs(left - right) == ('a' - 'A');
        }
        
        return false;
        
    }
}
