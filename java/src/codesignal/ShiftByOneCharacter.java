package codesignal;

public class ShiftByOneCharacter {
    public String shiftByOneCharacter(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if (('a' <= c && c <='z') || ('A' <= c && c <='Z')) {
                
                if (c == 'z'){
                    c = 'a';
                } else if (c == 'Z'){
                    c = 'A';
                } else {
                    c = (char) (c + 1);
                }
                
            }
            
            sb.append(c);
            
        }
        
        return sb.toString();
    }
}
