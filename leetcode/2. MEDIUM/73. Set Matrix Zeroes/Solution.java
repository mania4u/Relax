/*
	看似简单，但要注意特殊情况。
	之所以要设置两个布尔值主要是为了第一行还有第一列的特殊情况。
	大致思路就是，通过扫描找到值为0的点，
	并在第一行的matrix[0][j]和第一列的matrix[i][0]标记为0
	后面第二个双重for循环就是用来根据i和j补充0
	后面if(fr)和if(fc)都是用来描述特殊情况，
	也就是0出现在第一行或者第一列的情况
*/
public class Solution{
	public void setZeroes(int[][] matrix){
		boolean fr = false, fc = false;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					if(i == 0) fr = true;
					if(j == 0) fc = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0){
					matrix[i][j] = 0;
				}
			}
		}
		if(fr){
			for(int j = 0; j < matrix[0].length; j++){
				matrix[0][j] = 0;
			}
		}
		if(fc){
			for(int i = 0; i < matrix.length; i++){
				matrix[i][0] = 0;
			}
		}
	}
}