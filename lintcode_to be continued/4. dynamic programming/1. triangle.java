// bottom-up解法
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int n = triangle.length;
        int[][] dp = new int [n][n];    // 注意，三角形是一个等边直角三角形

        // 初始化
        for(int i = 0; i < n; i++){
            dp[n - 1][i] = triangle[n - 1][i];  // 先将底层的那一排给赋值作为初始值
        }

        for(int i = n - 2; i >= 0; i--){        // 从倒数第二排开始计算
            for(int j = 0; j <= i; j++){        // 
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
                // 由于只能跨一格，所以只需要从下面一层dp相邻两个值进行比较，加上本身这个点的值即可，并储存
            }
        }
        return dp[0][0];
    }
}

// top-down解法，远不如bottom-up的方法
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int n = triangle.length;
        int[][] dp = new int [n][n];    // 三角形是等边的

        // 初始化，与bottom-up不同，需要赋值两条边
        dp[0][0] = triangle[0][0];  // 注意这边得先给最顶点的dp[0][0]赋个初值
        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i - 1][0] + triangle[i][0];   // 给最左边的dp赋值
            dp[i][i] = dp[i - 1][i - 1]+ triangle[i][i];    // 给最右边的dp赋值
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < i; j++){
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];   // 同bottom-up
            }
        }

        int min = dp[n - 1][0];     // dp[n-1][0]作为比较的参照物
        for(int i = 0; i < n - 1; i++){     // 扫一遍最后一排的dp[n-1][i]里哪一个值最小
            min = Math.min(min, dp[n - 1][i + 1]);
        }
        return min;
    }
}