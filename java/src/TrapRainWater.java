public class TrapRainWater {
        /*
    TODO
    Analyze time complexity
    Analyze other solutions
    */
    public int trap(int[] h) {
        int l = 0, r = h.length - 1, sum = 0;

        while (r - l > 1) {

            if (h[l] <= h[l+1]) {
                l++;
                continue;
            }
            
            if (h[r-1] >= h[r]) {
                r--;
                continue;
            }

            int fill = Math.min(h[l], h[r]);

            for (int i = l+1; i < r; i++) {
                if (h[i] < fill) {
                    sum += fill - h[i];
                    h[i] = fill;
                }
            }
            
        }

        return sum;
    }
}


/*

olhar da esquerda pra direita quem é o maior

encontrar l cujo 
height[l] > height[l+1]


encontrar r cujo 
height[r-1] < height[r]


  l           r
0,2,0,3,1,0,1,3,2,1

  l           r
0,2,2,3,2,2,2,3,2,1

      l       r
0,2,2,3,2,2,2,3,2,1

      l       r
0,2,2,3,3,3,3,3,2,1





*/

