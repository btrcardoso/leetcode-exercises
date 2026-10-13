

class WordDictionary {

    WordDictionary[] arr = new WordDictionary[26];
    boolean isEnd = false;

    public WordDictionary() {}

    public void addWord(String word) {
        if (word.length() > 0) {
            char c = word.charAt(0);

            if (arr[c - 'a'] == null) {
                arr[c - 'a'] = new WordDictionary();
            } 

            arr[c - 'a'].addWord(word.substring(1, word.length()));

        } else {
            this.isEnd = true;
        }
    }

    public boolean search(String word) {
        if (word.length() > 0) {

            char c = word.charAt(0);

            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (arr[i] != null) {
                        boolean found = arr[i].search(word.substring(1, word.length()));
                        if (found) {
                            return true;
                        }                        
                    } 
                }

                return false;

            } else if (arr[c - 'a'] == null) {
                return false;
            } 

            return arr[c - 'a'].search(word.substring(1, word.length()));
        }

        return this.isEnd;
    }
}


/*


Trie:

WordDictionary[] arr = new WordDictionary[26];
boolean isEnd = false;


see if we have the letter, enter in the array.
add in the array in the isEnd.


search

if (curr.equals(".")) {
    find in everyone
} else {
    find in arr[cur - 'a']
}


*/
