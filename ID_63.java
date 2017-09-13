/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
**/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols-1] == 1) {
            return 0;
        }
        
        boolean force0 = false;
        for(int row=rows-1; row >= 0; row--) {
            if(force0 || obstacleGrid[row][cols-1] == 1) {
                obstacleGrid[row][cols-1] = 0;
                force0 = true;
            } else {
                obstacleGrid[row][cols-1] = 1;
            }
        }
        
        force0 = false;
        for(int col=cols-2; col >= 0; col--){
            if(force0 || obstacleGrid[rows-1][col] == 1) {
                obstacleGrid[rows-1][col] = 0;
                force0 = true;
            } else {
                obstacleGrid[rows-1][col] = 1;
            }
        }
                
        for(int row = rows-2; row >=0; row--) {
            for(int col = cols-2; col >=0; col--) {
                if(obstacleGrid[row][col] == 1) {
                    obstacleGrid[row][col] = 0;
                } else {
                    obstacleGrid[row][col] = obstacleGrid[row+1][col] + obstacleGrid[row][col+1];
                }
            }
        }
        
        return obstacleGrid[0][0];
    }
}
