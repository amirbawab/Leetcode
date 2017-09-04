/**
 *  Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 **/

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == needle.length()) {
            if(haystack.equals(needle)) {
                return 0;               
            } else {
                return -1;
            }
        }
        
        if(haystack.length() < needle.length()) {
            return -1;
        }
        
        for(int i=0; i < haystack.length(); i++) {
            int j = i;
            int k = 0;
            while(k < needle.length() && j < haystack.length() && haystack.charAt(j) == needle.charAt(k)) {
                k++;
                j++;
            }
            
            if(k == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
