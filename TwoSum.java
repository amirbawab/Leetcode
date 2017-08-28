import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.lang.RuntimeException;

/**
 * Link: https://leetcode.com/problems/two-sum/description/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *     Given nums = [2, 7, 11, 15], target = 9,
 *     Because nums[0] + nums[1] = 2 + 7 = 9,
 *     return [0, 1].
 * */

class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        System.out.println(Arrays.toString(ts.solution(new int[]{2,7,11,15}, 9)));
    }

    public int[] solution(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target-nums[i], i);
        }
        
        throw new RuntimeException("No solution");
    }
}
