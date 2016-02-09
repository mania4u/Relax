/*
	看上去挺唬人的一道题目，这道题的重点在于理解
	“O”在第一行，最后一行，第一列，最后一列相对其他“当中”元素的区别
	因为当“O”靠在边界，那他周围如果存在“O”也会相继不能被包围
	大致思路就是，将周围一群的“O”设置为特殊的“#”，
	然后根据边界“O”的这个点，向四周进行查找是否有相邻的“O”
	值存储在队列中，然后只要队列不为空，就接着按照每个点进行查找
	这样剩下的“O”肯定都被“X”包围了，直接替换即可
	看似代码量很大，很多重复的代码，莫怕O3O
*/

public class Solution{
	public void solve(char[][] board){
		if(board == null || board.length <= 1 || board[0].length <= 1) return;
		for(int i = 0; i < board[0].length; i++){
			fill(board, 0, i);
			fill(board, board.length - 1, i);
		}
		for(int i = 0; i < board.length; i++){
			fill(board, i, 0);
			fill(board, i, board[0].length - 1);
		}
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				else if(board[i][j] == '#')
					board[i][j] = 'O';
			}
		}
	}

	public void fill(char[][] board, int i, int j){
		if(board[i][j] != 'O') return;
		board[i][j] = '#';
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int code = i * board[0].length + j;
		queue.add(code);	// 记录下周围一圈里“O”的编号
		while(!queue.isEmpty()){
			code = queue.poll();
			int row = code / board[0].length;
			int col = code % board[0].length;
			if(row >= 1 && board[row - 1][col] == 'O'){		// 往上查找
				queue.add((row - 1) * board[0].length + col);	
				board[row - 1][col] = '#';
			}
			if(row <= board.length - 2 && board[row + 1][col] == 'O'){	// 往下查找
				queue.add((row + 1) * board[0].length + col);
				board[row + 1][col] = '#';
			}
			if(col >= 1 && board[row][col - 1] == 'O'){		// 往左查找
				queue.add(row * board[0].length + col - 1);
				board[row][col - 1] = '#';
			}
			if(col <= board[0].length - 2 && board[row][col + 1] == 'O'){	// 往右查找
				queue.add(row * board[0].length + col + 1);
				board[row][col + 1] = '#';
			}
		}
	}
}