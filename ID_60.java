/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 *     "123"
 *     "132"
 *     "213"
 *     "231"
 *     "312"
 *     "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * */

class Solution {
    public String getPermutation(int n, int k) {
        k--;
        int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= n; i++) {

            // Get number
            int iNumPoss = fact[n-i];
            int digit = (k / iNumPoss) + 1;

            // Append digit
            sb.append(nums[digit]);

            // Shift left
            for(int tmp= digit; tmp < nums.length-1; tmp++) {
                nums[tmp] = nums[tmp+1];
            }

            k %= iNumPoss;
        }

        return sb.toString();
    }
}

