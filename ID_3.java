/**
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left= 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()) {
            
            // If letter already exists
            if(set.contains(s.charAt(right))) {

                // Update the max window size
                max = Math.max(max, set.size());
                
                // Delete previous occurrence
                while(set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }                
            }
            set.add(s.charAt(right));
            right++;
        }
        return Math.max(max, set.size());
    }
}
