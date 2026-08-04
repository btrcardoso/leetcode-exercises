//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// sliding window
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        int r;

        for(r = n-k; r < n-1; r++){
            sum += cardPoints[r];
        }

        int maxPoint = 0;
        int l = n-k;

        while (r < n+k) {
            sum += cardPoints[r % n];
            maxPoint = Math.max(maxPoint, sum);
            sum -= cardPoints[l % n];
            l++;
            r++;
        }

        return maxPoint;

    }
}

/* Example
[1,2,3,4,5,6,1], k = 3

How the solution works:

[1,2,3,X,5,6,1]1,2,3
         5,6,1
           6,1]1
             1]1,2
              ]1,2,3
*/
