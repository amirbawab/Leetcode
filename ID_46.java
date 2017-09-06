/**
 *  Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * 
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
**/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        perm(nums, new boolean[nums.length], result, new Stack<Integer>());
        return result;
    }
    
    public void perm(int[] nums, boolean[] visited, List<List<Integer>> result, Stack<Integer> stack) {
        if(stack.size() == nums.length) {
            result.add(new ArrayList<Integer>(stack));
        } else {
            for(int i=0; i < nums.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    stack.push(nums[i]);
                    perm(nums, visited, result, stack);
                    stack.pop();
                    visited[i] = false;
                }           
            }
        }
    }
}
