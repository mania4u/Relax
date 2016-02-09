public class Solution{
	public boolean isValidSudoku(char[][] board){
		for(int i = 0; i < 9; i++){
			HashSet<Character> set = new HashSet<Character>();
			for(int j = 0; j < 9; j++){
				if(!isValid(set, board[i][j]))	
				// use the function below: isValid(HashSet<Character> set, char c)
					return false;
			}
		}
		for(int i = 0; i < 9; i++){
			HashSet<Character> set = new HashSet<Character>();
			for(int j = 0; j < 9; j++){
				if(!isValid(set, board[j][i]))
				// use the function below: isValid(HashSet<Character> set, char c)
					return false;
			}
		}
		for(int offset_y = 0; offset_y <= 6; offset_y += 3){
			for(int offset_x = 0; offset_x <= 6; offset_x += 3){
				HashSet<Character> set = new HashSet<Character>();
				for(int i = 0; i <= 2; i++){
					for(int j = 0; j <= 2; j++){
						if(!isValid(set, board[i+offset_x][j+offset_y]))	
						// use the function below: isValid(HashSet<Character> set, char c)
							return false;
					}
				}
			}
		}
		return true;
	}
	public boolean isValid(HashSet<Character> set, char c){
		if(c != '.' && !set.contains(c))	// if the number is not in the set, add the number into the set
			set.add(c);
		else if (c != '.' && set.contains(c))	// if the number already exists, return false
			return false;
		return true;
	}
}