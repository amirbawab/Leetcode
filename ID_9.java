/**
 * Link: https://leetcode.com/problems/palindrome-number/description/
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 * */

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        x = Math.abs(x);
        int len = (int)Math.log10(x) + 1;
        for(int i=0; i < len/2; i++) {
            int pow = (int) Math.pow(10, len - (i*2) - 1);
            int left = x / pow;
            int right = x % 10;
            x /= 10;
            x %= (pow/10);
            if(left != right) {
                return false;
            }
        }
        return true;
    }
}

// ALTERNATIVE SOLUTION (FASTER)
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        x = Math.abs(x);
        int reverse = 0;
        int original = x;
        while(x > 0) {
            reverse *= 10;
            reverse += x % 10;
            x /= 10;
        }
        return original == reverse;
    }
}
