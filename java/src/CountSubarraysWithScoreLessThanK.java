
//https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/
public class CountSubarraysWithScoreLessThanK {

    public long countSubarraysCerto(int[] nums, long k) {
        long count = 0, sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }
            count += (right - left + 1);
        }
        return count;
    }

//    public long countSubarrays(int[] nums, long k) {
//
//        if (nums.length < 1) return 0;
//
//        long count = 0;
//
//        for (int size = nums.length; size >= 1 ; size--) {
//            // sliding window
//            int sum = 0;
//            int left = 0;
//            int right = size - 1;
//            for (int i = left; i <= right; i++) {
//                sum += nums[i] * size;
//            }
//
//            do {
//                if (sum < k) {
//                    count ++;
//                }
//
//                // sum for next window
//                right++;
//                if (right < nums.length) {
//                    sum -= nums[left] * size;
//                    sum += nums[right] * size;
//                    left++;
//                }
//
//            } while (right < nums.length);
//
//        }
//
//        return count;
//
//    }



    // FIRST
//    public void print(int[] nums, int left, int right, int sum, int size) {
//        for (int i=left; i<=right; i++){
//            System.out.print(nums[i]*size + ", ");
//        }
//        System.out.println("Soma: "+ sum);
//    }
//
//    public long countSubarrays(int[] nums, long k) {
//        if (nums.length < 1) return 0;
//
//        long count = 0;
//
//        for (int size = nums.length; size >= 1 ; size --) {
//
//            // sliding window
//            int sumForSize = 0;
//            int leftPointer = 0;
//            int rightPointer = size - 1;
//            for (int i = leftPointer; i <= rightPointer; i++) {
//                sumForSize += nums[i] * size;
//            }
//
//            if (sumForSize < k) {
//                count ++;
//                //print(nums, leftPointer, rightPointer, sumForSize, size);
//            }
//
//            while (rightPointer + 1 < nums.length) {
//                // sum for next window
//                sumForSize -= nums[leftPointer] * size;
//                leftPointer++;
//
//                rightPointer++;
//                sumForSize += nums[rightPointer] * size;
//
//                if (sumForSize < k) {
//                    count ++;
//                    //print(nums, leftPointer, rightPointer, sumForSize, size);
//                }
//            }
//
//        }
//
//        return count;
//
//    }
}
