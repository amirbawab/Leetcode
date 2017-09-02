/*(
 * Link: https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, 
 * please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front. 
**/

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        
        if(str.length() == 1) {
            if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                return str.charAt(0) - '0';
            }
            return 0;
        }
        
        int sign = 1;
        int index = 0;
        int result = 0;
        if(str.charAt(0) == '-') {
            sign = -1;
            index++;
        }
        
        if(str.charAt(0) == '+') {
            sign = 1;
            index++;
        }
        
        while(index < str.length() && str.charAt(index) == '0') {
            index++;
        }
        
        int prev = 0;
        for(int i=index; i < str.length(); i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                return result;
            }
            prev = result;
            result *= 10;
            
            // Check multiplication overflow
            if(result / 10 != prev) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            if(sign == 1) {
                result += str.charAt(i) - '0';                
            } else {
                result -= str.charAt(i) - '0';
            }
            
            // Check addition overflow
            if(sign == 1 && result < 0 || sign == -1 && result >= 0) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return result;
    }
}
