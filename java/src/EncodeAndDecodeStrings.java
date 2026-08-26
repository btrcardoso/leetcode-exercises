import java.util.ArrayList;
import java.util.List;

//https://neetcode.io/problems/string-encode-and-decode/solution

public class EncodeAndDecodeStrings {

    // THIRD SOLUTION

/*

- iterate in each word

3#hey2#125#abcde

read number 3 first, iterate in each 3 charcater -> next character is a number until the next #

encode: 
- Time: O(n+m)
- Space: O(n+m)

decode:
- Time: O(n+m)
- Space: O(n+m)



*/


    // SECOND SOLUTION

    
    // strs: n, biggest word: m

    // Time complexity: n+m => O(n+m)
    // Space complexity: n+m => O(n+m)
    public String encode(List<String> strs) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {

            int len = strs.get(i).length();
            result.append(len);

            if (i < strs.size() - 1) {
                result.append(",");
            }

        }

        result.append("#");

        for (int i = 0; i < strs.size(); i++) {
            result.append(strs.get(i));
        }
     
        return result.toString();

    }

    // Time complexity: n+m => O(n+m)
    // Space complexity: n+m => O(n+m)
    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();
        if (str.length() < 2) {
            return result;
        }

        int sep = str.indexOf("#");
        String wordLensStr = str.substring(0, sep);
        str = str.substring(sep + 1, str.length());

        String[] wordLens = wordLensStr.split(",");

        for (int i = 0; i < wordLens.length; i++) {

            int wordLen = Integer.parseInt(wordLens[i]);

            if (wordLen == 0) {
                result.add("");
            } else {
                String word = str.substring(0, wordLen);
                result.add(word);
                str = str.substring(wordLen, str.length());
            }

        }

        return result;   
    }

















// FIRST SOLUTION -----------------------

    public final char LET_SEP = 'l';
    public final char WORD_SEP = 'w';

    // strs: n, biggest word: m

    // Time complexity: n * m => O(n*m) 
    // Space complexity: n * m => O(n*m) 
    public String encode_firstSolution(List<String> strs) {

        StringBuilder result = new StringBuilder();

        for (String word : strs){

            byte[] byteWord = word.getBytes();

            for (byte byteVal : byteWord) {
                result.append(byteVal);
                result.append(LET_SEP);
            }

            result.append(WORD_SEP);
        }

        return result.toString();
    }
    public List<String> decode_firstSolution(String str) {

        String[] words = str.split(String.valueOf(WORD_SEP), -1);

        List<String> result = new ArrayList<>();

        for (String word: words) {

            System.out.println(word);

            String[] letters = word.split(String.valueOf(LET_SEP));

            StringBuilder sbWord = new StringBuilder("");

            for (String letter : letters) {

                if (letter.length() > 0) {
                    int intVal = Integer.valueOf(letter);
                    char valChar = (char) intVal;

                    sbWord.append(valChar);
                }
                
            }

            result.add(sbWord.toString());
        }

        result.remove(result.size() - 1);
        return result;
    }

}
