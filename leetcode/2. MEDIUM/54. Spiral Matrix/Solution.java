public class Solution{
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> res = new ArrayList<Integer>();
		if(matrix.length == 0) return matrix;
		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;
		while(rowBegin <= rowEnd && colBegin <= colEnd){
			for(int j = colBegin; j <= colEnd; j++){	// 左上角向右
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;
			for(int j = rowBegin; j <= rowEnd; j++){	// 右上角向下
				res.add(matrix[j][colEnd]);
			}
			colEnd--;
			if(rowBegin <= rowEnd){
				for(int j = colEnd; j >= colBegin; j--){	// 右下角往左
					res.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;
			if(colBegin <= colEnd){		// 左下角向上
				for(int j = rowEnd; j >= rowBegin; j--){
					res.add(matrix[j][colBegin])
				}
			}
			colBegin++;
		}
		return res;
	}
}