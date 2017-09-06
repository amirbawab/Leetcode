/**
 *  Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * 
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * 
**/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
                    if(i == 0 || nums[i] != nums[i-1] || visited[i-1]) {
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
}
