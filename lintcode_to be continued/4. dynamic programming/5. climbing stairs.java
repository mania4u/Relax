public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        int[] dp = new int [n];

        if(n == 1 || n == 0){
        	return 1;
        }
        if(n == 2){
        	return 2;
        }
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
        	dp[i] = dp[i - 1] + dp[i - 2];		
        	// 因为只能走一步或者两步，否则再加上更前面的dp值
        	// 能走多少步，后面就相加多少个dp值
        }
        return dp[n - 1];
    }
}