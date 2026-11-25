package codesignal.stringSearchingAlgorithmsInJava;

import java.util.*;

public class MaxSubstringOcurrencesComMod {

    public static void main(String[] args) {
        int max = maxSubstringOccurrences("abcdabc",3);
        System.out.println("Maximo: " + max);

    }

    // Rabin Karp algorithm // rolling hashes
    public static int maxSubstringOccurrences(String text, int length) {

        if (length > text.length()) return 0;

        Map<Long, Integer> map = new HashMap<>();

        long base = 31L;
        long mod = 101;

        long hash = 0L;

        for (int i = 0; i < length; i++) {
            hash = (hash * base + simpleChar(text.charAt(i))) % mod;
        }

        printSubstr(text, 0, length, hash);
        map.put(hash, 1);

        int max = 1;

        long firstPower = ((long) Math.pow(base, length - 1)) % mod;

        for (int i = length; i < text.length(); i++) {

            int oldChar = simpleChar(text.charAt(i - length));
            int newChar = simpleChar(text.charAt(i));

            hash = ((hash - oldChar * firstPower) * base + newChar) % mod; // calcula hash com correção de intervalo, entre 0 e MOD
            hash = (hash + mod) % mod;                                     // deixa o hash positivo

            printSubstr(text, i - length + 1, i + 1, hash);

            int newQt = map.getOrDefault(hash, 0) + 1;
            map.put(hash, newQt);

            max = Math.max(newQt, max);
        }

        return max;
    }

    public static int simpleChar(char c){ // a:1, b:2, c:3 ...
        return c - 'a' + 1;
    }

    public static void printSubstr(String str, int start, int end, long hash) {
        System.out.println(str.substring(start, end) + ": " + hash);
    }    
}


    /*
    
    Solução map com hash para representar a string
    
    text = ABCDE, length = 3
    
    window = ABC
    hash = A * base² + B * base¹ + C
    
    window = BCD 
    hash = B * base² + C * base¹ + D
    
    window = CED 
    hash = C * base² + D * base¹ + E
    
    
    use o resto de mod, para diminuir o tamanho dos hashs. Nao usei, pq nao entendi como aplicar
     
    HASH = hash % mod.
    
    */