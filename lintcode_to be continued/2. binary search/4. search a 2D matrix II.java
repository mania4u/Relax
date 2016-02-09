// 注意坐标的填写，数组[纵向][横向]
// 左下扫到右上

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target){
        // write your code here
        // check corner case
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
            
        // from bottom left to top right
        int n = matrix.length;          // 纵向长度
        int m = matrix[0].length;       // 横向长度
        int x = n - 1;                  // 纵向坐标
        int y = 0;                      // 横向坐标
        int count = 0;

        while(x >= 0 && y < m){
            if(matrix[x][y] < target){
                y++;
            }else if(matrix[x][y] > target){
                x--;
            }else{
                count++;
                x--;
                y++;
            }
        }
        return count;
    }
}