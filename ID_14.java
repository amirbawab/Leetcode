/**
 * Link: https://leetcode.com/problems/longest-common-prefix/description/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String min = null;
        for(String s : strs) {
            if(min == null || min.length() > s.length()) {
                min = s;
            }
        }

        if(min == null) {
            return "";
        }
        
        for(int i=0; i < min.length(); i++) {
            for(int j=0; j < strs.length; j++) {
                if(strs[j].charAt(i) != min.charAt(i)) {
                    return min.substring(0, i);
                }
            }
        }
        return min;
    }
}
