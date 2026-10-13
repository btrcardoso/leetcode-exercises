import java.util.Arrays;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        int CAR[][] = new int[n][2];

        // Ordernar os carros de acordo com a posição em ordem descendente
        for (int i = 0; i < n; i++) {
            CAR[i][0] = position[i];
            CAR[i][1] = speed[i];
        }
        Arrays.sort(CAR, (a, b) -> Integer.compare(b[0], a[0]));

        // calcular o tempo pra chegar no target sem obstaculos e contar quantos sao os carros lideres lentos
        int fleet = 0;
        double aheadCarTime = 0;
        for (int i = 0 ; i < n; i++) {
            double time = (double) (target - CAR[i][0]) / CAR[i][1];

            if (time <= aheadCarTime) { // se ele é mais rápido ou igual ao carro da frente
                time = aheadCarTime;    // vira parte do fleet do carro da frente
            } else {
                fleet++;                // é um novo carro lider lento
            }
            aheadCarTime = time;
        }

        return fleet;
        
    }
}
/*


position = [1,4], speed = [3,2]
sort position in descending order and sort speed according to position
position = [4,1], speed = [2,3]

  1
        0
  
        1
            0  
  
              1
                0  
  
                    1 <- stuck together
                    0              
0,1,2,3,4,5,6,7,8,9,10



carFleet is the quantity of groups that will pass together in target.




calcular o tempo que cada carro chega no target sem obstaculos, da esquerda pra direita, 
verificar da esqeurda pra direita quantos são os carros lentos (tempos maiores) que se tornam líderes de um fleet
time = (target - position[i]) / speed[i];

----------------------------

target = 10
position = [4,0]
speed =    [2,5]
time =     [3,2]

--------------------------------

target = 10
position = [7,4,  1, 0]
speed =    [1,2,  2, 1]
time =     [3,3,4.5,10]


*/