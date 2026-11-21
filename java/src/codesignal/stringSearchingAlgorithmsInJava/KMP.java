package codesignal.stringSearchingAlgorithmsInJava;


/*

O objetivo desse algoritmo (KMP) é encontrar a primeira posição onde uma palavra (pattern) 
aparece dentro de um texto maior (text).
 
0 1 2 3 4 5 6 7 8 9 10 11
a b x a b c a b c a  b  y

            a b c a  b  y
            0 1 2 3  4  5

Result = 6

*/
public class KMP {
    public static int kmp(String text, String pattern) {

        int[] lps = LPS.computeLPSArray(pattern);

        int i = 0, j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                return i-j;

            } else if (i == text.length()) {
                break;

            } else if (text.charAt(i) != pattern.charAt(j) && j > 0) {
                j = lps[j - 1];  // se ele chegou a um certo sufixo, volta à posição do pattern após o prefixo igual ao ultimo sufixo percorrido.

            } else { // como j já está em 0, obriga a andar com i
                i++;
            }

        }


        return -1;
    }
}
