public class ContainerWithMostWater {

    public int maxArea(int[] h) {

        int l = 0, r = h.length - 1, maxArea = 0;

        while (l < r) {
            int height = Math.min(h[l], h[r]);
            int base = r - l;
            int area = height * base;
            maxArea = Math.max(area, maxArea);

            if (h[l] < h[r]) {
                l++;
            } else {
                r--;
            }
        } 

        return maxArea;
        
    }
}

/*


Brute force

i = 0
h[0] -> h[j]
    alt = min(h[0], h[j])
    base = modulo (0 - j)
    area =  alt * base

store the biggest area

-----------


I am measuring the height and distance



two pointers : l = 0, r = length - 1, I already start in the best distance.

calculate area and store.

h[l] < h[r]
    l ++;     <- to find a better h[l]
h[l] >= h[r]
    r --;     <- to find a better h[r]





*/
