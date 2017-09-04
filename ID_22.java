/**
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *  For example, given n = 3, a solution set is:
 *
 *  [
 *    "((()))",
 *    "(()())",
 *    "(())()",
 *    "()(())",
 *    "()()()"
 *  ]
 **/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, n, n, "");
        return list;
    }
    
    public void generate(List<String> list, int left, int right, String current) {
        
        // Do not allow unbalanced parenthesis
        if(right < left || left == -1) {
            return;
        }
        
        // If all parenthesis are consumed
        if(left == 0 && right == 0) {
            list.add(current);
            return;
        }
        
        // Generate parenthesis
        generate(list, left-1, right, current + '(');
        generate(list, left, right-1, current + ')');
    }
}
