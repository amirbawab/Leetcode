/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
**/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Prepare list
        List<List<Integer>> list = new ArrayList<>();
        
        // Sort the array
        Arrays.sort(nums);

        // Check if the list is small for the problem
        if(nums.length < 3) {
            return list;
        }

        // Start iterating over the array
        // to find the right combination
        for(int LL=0; LL < nums.length-2; LL++) {
            int LR = LL+1;
            int RR = nums.length-1;
            if(LL == 0 || nums[LL] != nums[LL-1]) {
                while(LR < RR) {
                    
                    int sum = nums[LL] + nums[LR] + nums[RR];
                    // System.out.println(key);
                    if(sum == 0) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[LL]);
                        subList.add(nums[LR]);
                        subList.add(nums[RR]);
                        list.add(subList);

                        while(LR < RR && nums[LR] == nums[LR+1]) {
                            LR++;                        
                        }

                        while(LR < RR && nums[RR] == nums[RR-1]) {
                            RR--;
                        }
                        LR++;
                        RR--;
                    } else if(sum < 0) {
                        while(LR < RR && nums[LR] == nums[LR+1]) {
                            LR++;                        
                        }
                        LR++;
                    } else {
                        while(LR < RR && nums[RR] == nums[RR-1]) {
                            RR--;
                        }
                        RR--;
                    }
                }
            }
            
        }

        return list;
    }
}

