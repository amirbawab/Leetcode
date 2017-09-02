/**
 * Link: https://leetcode.com/problems/reverse-integer/description/
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Note:
 * The input is assumed to be a 33-bit signed integer. 
 * Your function should return 0 when the reversed integer overflows.
 *
 * */
class Prob {
    public static void main(String[] args) {
        Prob p = new Prob();
        System.out.println(p.reverse(-123));
        System.out.println(p.reverse(-0));
        System.out.println(p.reverse(-321));
        System.out.println(p.reverse(Integer.MAX_VALUE));
        System.out.println(p.reverse(Integer.MIN_VALUE));
        System.out.println(p.reverse(1534236469));
    }

    public int reverse(int num) {

        // Calculate the inverse
        int sign = num < 0 ? -1 : 1;
        int cache = Math.abs(num);
        int result = 0;
        int prev = 0;
        while(cache > 0) {

            // Cache value
            prev = result;
            result *= 10;
            
            // Check multiplication overflow
            if(result / 10 != prev) {
                return 0;
            }

            // Get last digit to the right
            int digit = cache % 10;
            result += digit;
            cache/=10;
            
            // Check addition overflow
            if(result < 0) {
                return 0;
            }
        }

        // Recover the right sign
        result *= sign;

        return result;
    }
}
