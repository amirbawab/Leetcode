/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 **/
class Solution {
    public int trap(int[] height) {
        
        // Not enough walls to trap water
        if(height.length < 3) {
            return 0;
        }
        
        // Prepare pointers
        int left = 0;
        int right = height.length - 1;
        
        // Declare max values
        int lMax = 0;
        int rMax = 0;
        
        // Total water trapped
        int total = 0;
        
        // Calculate the amount of water trapped
        while(left < right) {
            
            // Update max heights
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            
            // Compare both sides heights
            if(height[left] > height[right]) {
                total += rMax - height[right];
                right--;
            } else {
                total += lMax - height[left];
                left++;
            }
        }
        return total;
    }
}
