public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0)
            return new int[]{-1, -1};
            
        int start, end, mid;
        int[] bound = new int[2];
        
        start = 0;
        end = A.length - 1;
        
        // find left bound
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(A[mid] == target){
                end = mid;
            }else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(A[start] == target){
            bound[0] = start;
        }else if(A[end] == target){
            bound[0] = end;
        }else{
            bound[0] = -1;
            bound[1] = -1;
            return bound;
        }
        
        // find right bound
        start = 0;
        end = A.length - 1;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(A[mid] == target){
                start = mid;
            }else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        // 注意找left bound和right bound，if语句中start和end先来后到的问题
        // left先判断start，right则先判断end
        if(A[end] == target){   
            bound[1] = end;
        }else if(A[start] == target){
            bound[1] = start;
        }else{
            bound[0] = -1;
            bound[1] = -1;
            return bound;
        }
        
        // get the final result
        return bound;
    }
}
