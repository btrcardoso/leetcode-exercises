public class ProductsOfArrayExceptSelf {
    // Time: O(n), Space: O(1)
     public int[] productExceptSelf(int[] nums) {

        int product = 1;
        int productAux = 1;
        int countZero = 0;

        for (int num : nums) {
            product = product * num;

            if (num != 0) {
                productAux = productAux * num;
            } else {
                countZero++;
            }
        }

        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            output[i] = nums[i] == 0 ? (countZero == 1 ? productAux : 0) : (product / nums[i]);
        }
        
        return output;
    }
}
