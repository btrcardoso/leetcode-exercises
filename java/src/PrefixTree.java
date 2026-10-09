
import java.util.*;
class PrefixTree {

    Map<Character, PrefixTree> children = new HashMap<>();
    boolean isFinal = false;

    public PrefixTree() {}

    public void insert(String word) {
        if (word.length() > 0) {

            PrefixTree child = children.getOrDefault(word.charAt(0), new PrefixTree());
            
            if (word.length() > 1) {
                child.insert(word.substring(1, word.length()));

            } else {
                child.isFinal = true;

            }

            this.children.put(word.charAt(0), child);
        }
    }

    public boolean search(String word) {
        if (word.length() > 0) {
            PrefixTree child = children.get(word.charAt(0));

            if (child == null) {
                return false;
            } 
            
            if (word.length() == 1) {
                return child.isFinal;
            }

            return child.search(word.substring(1, word.length()));
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        if (prefix.length() > 0) {
            PrefixTree child = children.get(prefix.charAt(0));

            if (child == null) {
                return false;
            } 
            
            if (prefix.length() == 1) {
                return true;
            }

            return child.startsWith(prefix.substring(1, prefix.length()));
        }

        return true;
    }
}

/*

efficiently store and retrieve
keys
set of strings


autocomplete, spell checker systems

prefix.





*/



