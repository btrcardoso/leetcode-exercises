package codesignal.stringSearchingAlgorithmsInJava;

import java.util.*;

public class MaxSubstringOcurrences {
    // Rabin Karp algorithm // rolling hashes
    public static int maxSubstringOccurrences(String text, int length) {
        
        if (length > text.length()) return 0;
        
        Map<Long, Integer> map = new HashMap<>();
        
        long base = 31L;           // numero primo pequeno, geralmente 31
        long mod = 1_000_000_007;  // TODO: numero primo grande
        
        // hash = A * base² + B * base¹ + C
        Long hash = 0L;
        for (int i = 0; i < length; i++) {
            hash = hash * base + text.charAt(i);
        }
        
        map.put(hash, 1);
        
        int max = 1;
        
        // firstPower = base ^ (length - 1)
        long firstPower = 1;
        for(int i = 1; i < length; i++) {
            firstPower = firstPower * base;
        }
        
        for (int i = length; i < text.length(); i++) {
            char oldChar = text.charAt(i - length);
            char newChar = text.charAt(i);
            
            hash = hash - oldChar * firstPower; // remove o primeiro caracter
            hash = hash * base;                 // multiplica tudo pela base
            hash = hash + newChar;              // adiciona o ultimo caractere

            
            int newQt = map.getOrDefault(hash, 0) + 1;
            map.put(hash, newQt);  
            max = Math.max(newQt, max);
        }
                
        return max;
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
    
    
    public static int maxSubstringOccurrences_naive(String text, int length) {
        
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        
        for (int i = 0; i <= text.length() - length; i++) {
            String sub = text.substring(i , i + length);
            
            int newQt = map.getOrDefault(sub, 0) + 1;
            map.put(sub, newQt);
            
            max = Math.max(newQt, max);
        }
        
        return max;
    }
    
}