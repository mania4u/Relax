// 自下而上求解

public class Solution{
	public int minimumTotal(List<List<Integer>> triangle){
		if(triangle.size() == 1)
			return triangle.get(0).get(0);

		int[] dp = new int[triangle.size()];
		// 三角最后一行的数组
		for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i++){
			dp[i] = triangle.get(triangle.size() - 1).get(i);
		}
		// 从倒数第二行开始
		for(int i = triangle.size() - 2; i >= 0; i--){		// 一维，层数的循环
			for(int j = 0; j < triangle.get(i).size(); j++){	// 二维，每一“层内”的循环
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
				// 虽然这边求的是从倒数第二层开始的，
				// 但是Math.min(dp[j], dp[j+1])带入的则是最后一层保存好的dp数组
			}
		}
		return dp[0];
	}
}