/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 **/
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        
        // Solution using combination
        // Example:
        // +---+---+---+
        // |   |   |   |
        // +---+---+---+
        // |   |   |   |
        // +---+---+---+
        // |   |   |   |
        // +---+---+---+
        // Total steps: > > v v (Total steps: 2 right and 2 down)
        // so: (4 C 2, 2) = 4! / (2! * 2!) = 6
        //
        
        // Alternative solution
        // +---+---+---+
        // |res|...| 1 |
        // +---+---+---+
        // |...|r+b| 1 |
        // +---+---+---+
        // | 1 | 1 | 1 |
        // +---+---+---+
        // 
        int[][] board = new int[m][n];
        for(int col=0; col < n; col++) {
            board[m-1][col] = 1;
        }
        for(int row=0; row < m; row++) {
            board[row][n-1] = 1;
        }
        for(int row=m-2; row >= 0; row--) {
            for(int col=n-2; col >= 0; col--) {
                board[row][col] = board[row+1][col] + board[row][col+1];
            }
        }
        return board[0][0];
    }
}
