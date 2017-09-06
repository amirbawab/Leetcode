/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 **/
class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i < nums.length; i++) {
            int curIndex = nums[i]-1;
            if(curIndex >= 0 && curIndex < nums.length && curIndex != i && nums[curIndex] != nums[i]) {
                if(curIndex < i) {
                    nums[curIndex] = nums[i];
                } else {
                    int tmp = nums[curIndex];
                    nums[curIndex] = nums[i];
                    nums[i] = tmp;
                    i--;
                }
            }
        }
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
