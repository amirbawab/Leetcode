/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
**/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return binarySearch2(nums, target, 0, nums.length-1);
    }
    
    public int binarySearch(int[] nums, int target, int left, int right, boolean leftSide) {
        
        // If overlap
        if(left > right) {
            return -1;
        }
        
        // Calculate mid index
        int mid = (left + right + 1) / 2;

        // Check if target found
        if(nums[mid] == target) {
            if(leftSide) {
                int index = binarySearch(nums, target, left, mid-1, leftSide);
                if(index == -1) {
                    return mid;
                }
                return index;
            } else {
                int index = binarySearch(nums, target, mid+1, right, leftSide);
                if(index == -1) {
                    return mid;
                }
                return index;
            }
        }
        
        // If target value is greater than the mid one
        if(target > nums[mid]) {
            return binarySearch(nums, target, mid+1, right, leftSide);
        }
        
        // If target value is lower than the mid one
        return binarySearch(nums, target, left, mid-1, leftSide);
    }
    
    public int[] binarySearch2(int[] nums, int target, int left, int right) {
        
        // If overlap
        if(left > right) {
            return new int[]{-1,-1};
        }
        
        // Calculate mid index
        int mid = (left + right + 1) / 2;

        // Check if target found
        if(nums[mid] == target) {
            // Prepare left data
            int lIndex = binarySearch(nums, target, left, mid, true);
            int rIndex = binarySearch(nums, target, mid, right, false);
            return new int[]{lIndex, rIndex};
        }
        
        // If target value is greater than the mid one
        if(target > nums[mid]) {
            return binarySearch2(nums, target, mid+1, right);
        }
        
        // If target value is lower than the mid one
        return binarySearch2(nums, target, left, mid-1);
    }
}
