package codesignal.introductionToStringManipulation;

public class RepeatSubstring {
    public static String repeatSubstring(String s) {
        
        int i = 2;
        int len = s.length();
        
        while (i <= len) {
            
            if (len % i == 0) {
                
                int subLen = len / i;
                String cur = s.substring(0, subLen);
                
                int j;
                for (j = subLen; j < len; j += subLen) {
                    if (!cur.equals(s.substring(j, j + subLen))) {
                        break;
                    }
                }
                
                if (j == len) {
                    return cur;
                }
                
            }
            
            i++;
        }
        
        return "";
    }
}



/*

abab abab s % 2 == 0, conferir já é..

aba bab ab, s % 3 != 0 , pula

ab ab ab ab s % 4 == 0, conferir


se s/i == 1, confere e retorna













*/