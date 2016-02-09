/*
	DFS。每次做DFS之前都标记将走过的路标记为“0”，防止走回头路
	举个例子
	11000			 	00000
	11000	最后一轮   	01000
	00100   DFS前→ 		00100
	00011			 	00001
	往四个方向扩展，直到四周都是“0”
	也就是找到以“1”构成的“island”的外部轮廓
*/
public class Solution{
	char[][] g;
	public int numIslands(char[][] grid){
		int islands = 0;
		g = grid;
		for(int i = 0; i < g.length; i++){
			for(int j = 0; j < g[i].length; j++){
				islands += sink(i, j);
			}
		}
		return islands;
	}

	public int sink(int i, int j){
		if(i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0')
			return 0;
		g[i][j] = '0';		// 为了不走回头路
		sink(i + 1, j);
		sink(i - 1, j);
		sink(i, j + 1);
		sink(i, j - 1);
		return 1;
	}
}