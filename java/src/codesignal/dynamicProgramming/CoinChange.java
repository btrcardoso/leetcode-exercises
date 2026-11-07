package codesignal.dynamicProgramming;

/*
In this task, your goal is to find the number of distinct ways you can make change for a target amount, given an array of available coin denominations. Specifically, you need to write a Java method coinChange(int[] coins, int amount), where:

coins is an array of integers representing the available denominations. Each denomination can be used an unlimited number of times. This array contains unique numbers.
amount is a non-negative integer representing the target amount.
The method should return an integer — the number of distinct ways you can combine the coins to sum up to the target amount. If there is no possible combination that would result in the target amount, return 0.

The expected time complexity of your solution is O(amount * coins.length).

*/

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        
        int[] memo = new int[amount + 1];
        
        memo[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin ; i <= amount; i++) {
                memo[i] += memo[i - coin];
            }
        }
        
        return memo[amount];
        
    }  
}

/*

A intuição é pensar assim:

Quando o loop de fora processa uma moeda (por exemplo, coin = 2), 
estamos dizendo: "vamos ver quantos novos caminhos surgem agora que liberamos o uso da moeda 2".

Para qualquer valor i, o número de novas formas de formá-lo usando pelo menos uma moeda 2 é exatamente quantas formas existiam para formar o restante, 
ou seja, i - 2.

Como processamos uma moeda de cada vez, todas as combinações formadas são geradas numa ordem fixa de moedas (primeiro só moedas 1, 
depois adicionando moedas 2), o que impede a repetição de permutações como [1, 2] e [2, 1].
*/


/*


               
coinChange({1, 2}, 4);

inicio
     0,1,2,3,4
    [1, , , , ]  ()

coin=1
     0,1,2,3,4
i=1 [1,1, , , ] {0+}=(1)
i=2 [1,1,1, , ] {1+}=(1,1)
i=3 [1,1,1,1, ] {2+}=(1,1,1)
i=4 [1,1,1,1,1] {3+}=(1,1,1,1)  

coin=2
     0,1,2,3,4
i=2 [1,1,2,1,1] (1,1) {0+}=(2)
i=3 [1,1,2,2,1] (1,1,1) {1+}=(1,2)
i=4 [1,1,2,2,3] (1,1,1,1) {2+}=(1,1,2)(2,2)





-----------------------------

coinChange({1, 2, 5}, 11)

inicio
     0,1,2,3,4,5,6,7,8,9,10,11
    [1, , , , , , , , , ,  ,  ] 

coin=1
      0,1,2,3,4,5,6,7,8,9,10,11
i= 1 [1,1, , , , , , , , ,  ,  ] {0+}=(1)
i= 2 [1,1,1, , , , , , , ,  ,  ] {1+}=(1,1)
i= 3 [1,1,1,1, , , , , , ,  ,  ] {2+}=(1,1,1)
i= 4 [1,1,1,1,1, , , , , ,  ,  ] {3+}=(1,1,1,1)
i= 5 [1,1,1,1,1,1, , , , ,  ,  ] {4+}=(1,1,1,1,1)
i= 6 [1,1,1,1,1,1,1, , , ,  ,  ] {5+}=(1,1,1,1,1,1)
i= 7 [1,1,1,1,1,1,1,1, , ,  ,  ] {6+}=(1,1,1,1,1,1,1)
i= 8 [1,1,1,1,1,1,1,1,1, ,  ,  ] {7+}=(1,1,1,1,1,1,1,1)
i= 9 [1,1,1,1,1,1,1,1,1,1,  ,  ] {8+}=(1,1,1,1,1,1,1,1,1)
i=10 [1,1,1,1,1,1,1,1,1,1, 1,  ] {9+}=(1,1,1,1,1,1,1,1,1,1)
i=11 [1,1,1,1,1,1,1,1,1,1, 1, 1] {10+}=(1,1,1,1,1,1,1,1,1,1,1)

coin=2
      0,1,2,3,4,5,6,7,8,9,10,11
i= 2 [1,1,2,1,1,1,1,1,1,1, 1, 1] (1,1) {0+}=(2)
i= 3 [1,1,2,2,1,1,1,1,1,1, 1, 1] (1,1,1) {1+}=(1,2)
i= 4 [1,1,2,2,3,1,1,1,1,1, 1, 1] (1,1,1,1) {2+}=(1,1,2)(2,2)
i= 5 [1,1,2,2,3,3,1,1,1,1, 1, 1] (1,1,1,1,1) {3+}=(1,1,1,2)(1,2,2)
i= 6 [1,1,2,2,3,3,4,1,1,1, 1, 1] (1,1,1,1,1,1) {4+}=(1,1,1,1,2)(1,1,2,2)(2,2,2)
i= 7 [1,1,2,2,3,3,4,4,1,1, 1, 1] (1,1,1,1,1,1,1) {5+}=(1,1,1,1,1,2)(1,1,1,2,2)(1,2,2,2)
i= 8 [1,1,2,2,3,3,4,4,5,1, 1, 1] (1,1,1,1,1,1,1,1) {6+}=(1,1,1,1,1,1,2)(1,1,1,1,2,2)(1,1,2,2,2)(2,2,2,2)
i= 9 [1,1,2,2,3,3,4,4,5,5, 1, 1] (1,1,1,1,1,1,1,1,1) {7+}=(1,1,1,1,1,1,1,2)(1,1,1,1,1,2,2)(1,1,1,2,2,2)(1,2,2,2,2)
i=10 [1,1,2,2,3,3,4,4,5,5, 6, 1] (1,1,1,1,1,1,1,1,1,1) {8+}=(1,1,1,1,1,1,1,1,2)(1,1,1,1,1,1,2,2)(1,1,1,1,2,2,2)(1,1,2,2,2,2)(2,2,2,2,2)
i=11 [1,1,2,2,3,3,4,4,5,5, 6, 6] (1,1,1,1,1,1,1,1,1,1,1) {9+}=(1,1,1,1,1,1,1,1,1,2)(1,1,1,1,1,1,1,2,2)(1,1,1,1,1,2,2,2)(1,1,1,2,2,2,2)(1,2,2,2,2,2)

coin=5
i= 5 ...cansei
i= 6 
i= 7 
i= 8 
i= 9 
i=10 
i=11 



         
         

*/
