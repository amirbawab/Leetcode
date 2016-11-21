public class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        int total = 0;
        
        while(left <= right) {
            
            maxL = Math.max(maxL, height[left]);
            maxR = Math.max(maxR, height[right]);
            
            if(height[left] < height[right]) {
                
                if(height[left] < maxL && height[left] < maxR) {
                    total+= Math.min(maxL, maxR) - height[left];
                }
                
                left++;
            } else {
                
                if(height[right] < maxL && height[right] < maxR) {
                    total+= Math.min(maxL, maxR) - height[right];
                }
                
                right--;
            }
        }
        return total;
    }
}
