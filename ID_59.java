/**
 * Given an integer n, generate a square matrix filled with 
 * elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 **/

class Solution {
    public int[][] generateMatrix(int n) {
        int counter = 1;
        int[][] matrix = new int[n][n];
        int iters = (n+1) / 2;
        for(int i=0; i < iters; i++) {
            
            // Top: Left to right
            for(int lr=i; lr < n - i; lr++) {
                matrix[i][lr] = counter++;
            }

            // Righ: Top to bottom 
            for(int tb=i+1; tb < n - i; tb++) {
               matrix[tb][n-i-1] = counter++; 
            }
           
            // Bottom: Right to left 
            for(int rl=n-i-2; rl >= i; rl--) {
                matrix[n - i - 1][rl] = counter++;
            }
            //
            // Left: Bottom to top
            for(int bt=n - 2 - i; bt >= i+1; bt--) {
               matrix[bt][i] = counter++; 
            }
        }
        return matrix;
    }
}
