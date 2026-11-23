package codesignal.stringSearchingAlgorithmsInJava;

/*
https://codesignal.com/learn/course/481/unit/4/practice/3

You are given a text string and a number length. Your task is to count the number of substrings of exactly length characters in the string that are palindromes.

A string is a palindrome if it reads the same backward as forward.

Method signature: public static int countPalindromes(String text, int length)

For instance,

Java
Copy to clipboard
String text = "madamargentinamanitnegra";
int length = 5;
System.out.println(Solution.countPalindromes(text, length)); // Output: 2
should return 2 because there are three substrings of length 5 that are palindromes: madam, and naman.

The expected time complexity for this task is linear, which is $O(text.length)$.

Usando rolling hash / robin karp
*/

public class CountingPalindromicSubstrings {
    public static int countPalindromes(String text, int length) {
        
        if (length == 1) {
            return text.length();
        }
        
        int count = 0;
        
        // base (valor primo arbitrario)
        long base = 11;
        long acumBase = 1;  
        
        // hashes da esquerda e direita
        long left = 0;
        long right = 0; 
        
        // tamanho das 2 metades do palindromo
        int half = length / 2;
        int res = length % 2;
        
        // calcula o hash da esquerda e direita da primeira substring
        for (int i = 0; i < half; i++) {
            left = left * base + text.charAt(i);
            right = right + text.charAt(i + half + res) * acumBase;
            acumBase *= base;                
        }
        if (left == right) count++;
        
        // percorre a janela calculando os hashes da esquerda e direita das substrings
        long highestPower = (long) Math.pow(base, half - 1);
        for (int i = length; i < text.length(); i++) {
            char oldChar = text.charAt(i - length);
            char newChar = text.charAt(i - length + half);
            left = left - highestPower * oldChar;
            left = left * base;
            left = left + newChar;
            
            oldChar = text.charAt(i - half);
            newChar = text.charAt(i);
            right = right - oldChar;  
            right = right / base;       
            right = right + newChar * highestPower;
            
            if (left == right) count++;            
        }
        
        return count;
    }
}


/*

text = ABCBAC
length = 5
half = 2

ABCBA
left(AB) = A*b¹ + B*b⁰
mid(C) = C
right(BA) = B*b⁰ + A*b¹

BCBAC
left(BC) =        B*b¹ + C*b⁰
mid(B) = B
right(AC) =        A*b⁰ + C*b¹ 



*/