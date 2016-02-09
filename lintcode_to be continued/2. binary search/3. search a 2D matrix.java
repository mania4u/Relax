// 两次二分

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
        	return false;

        // find element in first column
        int start = 0;
        int end = matrix.length - 1;
        int tmp;
        while(start + 1 < end){
        	int mid = start + (end - start) / 2;
        	if(matrix[mid][0] < target){
        		start = mid;
        	}else if(matrix[mid][0] == target){
        		return true;
        	}else{
        		end = mid;
        	}
        }
        if(matrix[start][0] == target || matrix[end][0] == target){
            return true;
        }else if(matrix[start][0] < target && target < matrix[end][0]){
        	tmp = start;
        }else if(matrix[end][0] < target){
            tmp = end;
        }else{
        	return false;
        }

        // find element in the row
        start = 0;
        end = matrix[tmp].length - 1;
        while(start + 1 < end){
        	int mid = start + (end - start) / 2;
        	if(matrix[tmp][mid] == target){
        		return true;
        	}else if(matrix[tmp][mid] < target){
        		start = mid;
        	}else{
        		end = mid;
        	}
        }
        if(matrix[tmp][start] == target){
        	return true;
        }else if(matrix[tmp][end] == target){
        	return true;
        }else{
        	return false;
        }
    }
}