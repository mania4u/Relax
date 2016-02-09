public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1)     // 障碍本来为1，这边设置为0
                    obstacleGrid[i][j] = 0;
                else if(i == 0 && j == 0)   // 原点
                    obstacleGrid[i][j] = 1;
                else if(i == 0)     // 第一行赋值为1
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];// For row 0, if there are no paths to left cell, then its 0,else 1
                else if(j == 0)     // 第一列赋值为1
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];// For col 0, if there are no paths to upper cell, then its 0,else 1
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[m - 1][n - 1];

    }
}