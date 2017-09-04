/**
 *  Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 *  find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 
 *     All numbers (including target) will be positive integers.
 *     The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * 
 * [
 *   [7],
 *   [2, 2, 3]
 * ]
 * 
 **/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        recursive(list, candidates, new Stack<Integer>(), target, 0);
        return list;
    }
    
    public void recursive(List<List<Integer>> list, int[] nums, Stack<Integer> stack, int total, int index) {
        
        // If total found
        if(total == 0) {
            list.add(new ArrayList<Integer>(stack));
            return;
        }
        
        // If still can handle numbers
        if(total > 0) {
            for(int i=index; i < nums.length && total - nums[i] >= 0; i++) {
                stack.push(nums[i]);
                recursive(list, nums, stack, total-nums[i], i);
                stack.pop();
            }
        }
    }
}
