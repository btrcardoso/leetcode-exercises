class TrapRainWater {

    // TODO try again the best approach
    public int trap(int[] h) {
        return 0;
    }




    public int trap_prefixSufixArrays(int[] h) {
        int n = h.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = h[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(h[i], leftMax[i-1]);
        }

        rightMax[n-1] = h[n-1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(h[i], rightMax[i+1]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - h[i];
        }

        return sum;
    }

/* water = Math.min(leftMax, rightMax) - h[i]

           0,2,0,3,1,0,1,3,2,1
leftMax = [0,2,2,3,3,3,3,3,3,3]
rightMax= [3,3,3,3,3,3,3,3,2,1]
water   = [0,2,2,3,3,3,3,3,2,1]

*/



// -----------------------------------


    /*
    Time complexity: O(n²)
    Space complexity: O(1)
    */
    public int trap_bruteforce(int[] h) {
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



worst case
1 0 2 0 3 0 4 0 3 0 2 0 1

*/