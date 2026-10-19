package hackerhank;

import java.io.*;
import java.util.*;

class Result {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        
        int[] remainders = new int[k];
        
        // Conta a quantidade de numeros com o resto especificado
        for (Integer num : s) {
            int rest = num % k;
            remainders[rest]++;
        }
        
        int result = 0;
        
        for (int i = 0; i <= k/2; i++) {
            
            // o resto que combinado com i, produz uma soma divisivel por k
            // ou seja, dois restos que nao podem ser incluidos juntos no conjunto
            int opposite = i == 0 ? 0 : k - i; 
            
            if (i == opposite) {  // i == 0, ou i == k/2 para k par
            
                // somente um podera entrar no conjunto
                result += Math.min(remainders[i], 1);     
                
            } else {
                
                // escolhera o que mais tem numeros pra entrar no conjunto
                result += Math.max(remainders[i], remainders[opposite]);   
            }
            
        }
        
        return result;
    }

}

public class NonDivisibleSubSet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

