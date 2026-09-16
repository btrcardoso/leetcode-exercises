package hackerhank;

public class JavaStringTokens {
    public static void main(String[] args) {
        String s = "                        "; //"           YES      leading spaces        are valid,    problemsetters are         evillllll";
        
        if(s.trim().length() == 0) {
            System.out.println(0);
        } else {
            String[] tokens = s.trim().split("[^A-Za-z]+");
        
            System.out.println(tokens.length);
            for(String token : tokens) {
                System.out.println(token);
            }  
        }
    }
}
