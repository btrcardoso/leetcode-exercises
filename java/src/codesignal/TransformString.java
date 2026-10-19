package codesignal;

public class TransformString {
        public String transformString(String inputString) {
        StringBuilder sb = new StringBuilder();
            
        int distance = 'a' - 'A';
        
        for (int i = 0; i < inputString.length(); i++) {
            
            char c = inputString.charAt(i);
            
            if ('a' <= c && c <= 'z') {
                
                c = (char) (c - distance);
                
            } else if ('A' <= c && c <= 'Z') {
                
                c = (char) (c + distance);
                
            } 
            
            sb.append(c);
            
        }
        
        
        return sb.toString();
    }
}
