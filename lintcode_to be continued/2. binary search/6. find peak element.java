//普通解法
class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A == null || A.length == 0)
            return -1;
            
        for(int i = 1; i < A.length - 1; i++){
            if(A[i - 1] < A[i] && A[i] > A[i + 1])
                return i;
        }
        return -1;
    }
}

// 二分解法
// 注意：因为数字都是不同的才能有下面的解法
class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A == null || A.length == 0)
            return -1;
        
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid - 1] < A[mid]){
            // 包含了两种情况：1. A[mid-1]<A[mid]>A[mid+1] 2. A[mid-1]<A[mid]<A[mid+1]
                if(A[mid] > A[mid + 1]){
                    return mid;
                }else{
                    start = mid;
                }
            }else if(A[mid - 1] > A[mid]){
            // 包含了两种情况：1. A[mid-1]>A[mid]>A[mid+1] 2. A[mid-1]>A[mid]<A[mid+1]
                end = mid;
            }
        }
        return -1;
    }
}
