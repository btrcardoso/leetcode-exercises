package hackerhank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://www.hackerrank.com/challenges/duplicate-word/problem?isFullScreen=true
public class JavaRegex2DuplicateWords {
    public static void main(String[] args) {

        /*
        \\b            boundary
        (\\w+)         1° group
        \\s            space
        (\\1\\s+)*     possible repetition of the 1° group with spaces
        (\\1)          repetition of the 1° group
        \\b            boundary
        */
        String regex = "\\b(\\w+)\\s(\\1\\s+)*(\\1)\\b";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        String input = 
            //"I love love to to to code"
            // "I love Love to To tO code"
            // "Goodbye bye bye world world world"
            "in inthe"
        ;
        Matcher m = p.matcher(input);
        
        // Check for subsequences of input that match the compiled pattern
        while (m.find()) {
            System.out.println("Match found: " + m.group());
            input = input.replaceAll(m.group(),m.group(1));
        }
        
        // Prints the modified sentence.
        System.out.println(input);
        
    }
}
