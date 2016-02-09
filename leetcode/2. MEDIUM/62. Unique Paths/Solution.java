/*
	思路比较特别，但又比较典型，说特别是因为以前没好好学= =||
	第一排的横向纵向各输入1，因为不能走回头路，也不能向上和向左
	两条边的每个位置都只有一种走法，
	m[i][j]等于左边和上面两个m[i-1][j]和m[i][j-1]的和，神奇吧~
	举例5*3的长方形：
	1	1	1	1	1
	1	2	3	4	5
	1	3	6	10	15	所以答案就是15~
*/
public class Solution{
	public int uniquePaths(int m, int n){
		Integer[][] map = new Integer[m][n];
		for(int i = 0; i < m; i++){
			map[i][0] = 1;
		}
		for(int j = 0; j < n; j++){
			map[0][j] = 1;
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		return map[m - 1][n - 1];
	}
}