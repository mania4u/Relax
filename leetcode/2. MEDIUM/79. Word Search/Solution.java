// 题意：贪吃蛇，在一个二维数组内，能向左向右，能找到相同的word

public class Solution{
	public boolean exist(char[][] board, String word){
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(dfs(board, word, 0, i, j, visited)) return true;
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, String word, int index, int rowindex, int colindex, boolean[][] visited){
		if(index == word.length()) return true;		// 如果之前最后执行的index和word长度相同则返回true
		if(rowindex < 0 || colindex < 0 || rowindex >= board.length || colindex >= board[0].length) return false;
		// row和col的边界
		if(visited[rowindex][colindex]) return false;
		// 因为不能走重复的路，走过的路标记为false
		if(board[rowindex][colindex] != word.charAt(index)) return false;	// board上的字符与word的匹配
		visited[rowindex][colindex] = true;		// 如果是没走过的，则标记为true
		boolean res = dfs(board, word, index + 1, rowindex - 1, colindex, visited)	// 向左递归
		        || dfs(board, word, index + 1, rowindex + 1, colindex, visited)		// 向右递归
		        || dfs(board, word, index + 1, rowindex, colindex + 1, visited) 	// 向上递归
		        || dfs(board, word, index + 1, rowindex, colindex - 1, visited);	// 向下递归
		visited[rowindex][colindex] = false;	// 进行递归之后，这个点则标记为false	
		return res;          
	}
}