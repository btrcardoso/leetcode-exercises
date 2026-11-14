
package leetcode.backtracking;

import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "dog", "sand")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cat", "cats", "and", "dog", "sand")));

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {

        List<String> result = new ArrayList<>();

        List<String> prefixes = findPrefixesInDict(s, wordDict);

        for (String prefix : prefixes) {

            String subString = s.substring(prefix.length());

            if (subString.length() == 0) {
                result.add(prefix);

            } else {
                List<String> combinations = wordBreak(subString, wordDict);
        
                for (String comb : combinations) {
                    result.add(prefix + " " + comb);
                }
            }

        }

        return result;

    }

    public static List<String> findPrefixesInDict(String str, List<String> wordDict) {

        List<String> prefixes = new ArrayList<>();

        for (String word : wordDict) {

            for (int i = 1; i <= str.length(); i++) {

                String subStr = str.substring(0, i);
                if (word.equals(subStr)) {
                    prefixes.add(word);

                } else if (!word.startsWith(subStr)) {
                    break;
                }

            }

        }

        return prefixes;
    }
}



/*

[cat, cats, and, dog]


catsandog

i = 0

word.startsWith(sub)




*/