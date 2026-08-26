public class 3Sum {

    /*
    

    Time: O(n²)
    Space: O(1)

    
    [-1,0,1,2,-1,-4]
    Sort it
    [-4,-1,-1,0,1,2]
    get nums[i], do two sum  in the rest.


    triplets (i, l, r)
    guarantee that elements, i-1, l-1, and r+1 are not the same as i, l and r, respectively.
    
    
    */

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i=0 ; i<nums.length - 2; i++) {

            if (i > 0 && nums[i-1] == nums[i]) continue;

            int l = i+1, r = nums.length - 1;

            int target = - nums[i];
            while (l < r) {

                int sum = nums[l] + nums[r];
                boolean lAlreadySeen = (l > i+1) && (nums[l-1] == nums[l]);
                boolean rAlreadySeen = (r < nums.length - 1) && (nums[r+1] == nums[r]);

                if (sum < target || lAlreadySeen) { 
                    l++;
                } else if (sum > target || rAlreadySeen) {
                    r--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
            }

        }

        return result;

    }



    

    public List<List<Integer>> threeSum_(int[] nums) {

        Arrays.sort(nums); // -4,-1,-1,0,1,2

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            countMap.put(nums[i], countMap.get(nums[i]) - 1);

            // garante que o valor anterior não seja mais o primeiro das triplas adicionadas, pois já foi adicionado
            if (i > 0 && nums[i-1] == nums[i]) continue; 

            for (int j = i+1; j < nums.length - 1; j++) {
                countMap.put(nums[j], countMap.get(nums[j]) - 1);

                // garante que o valor anterior não seja mais o segundo das triplas adicionadas, pois já foi adicionado
                if (j > i+1 && nums[j-1] == nums[j]) continue; 

                int diff = -(nums[i] + nums[j]);
                int diffCount = countMap.getOrDefault(diff, 0);
                if (diffCount > 0) {
                    result.add(Arrays.asList(nums[i], nums[j], diff)); // adição da tripla
                }

            }

            for (int j = i+1; j < nums.length - 1; j++) {
                countMap.put(nums[j], countMap.get(nums[j]) + 1);
            }

        }


        return result;      

    }
}
