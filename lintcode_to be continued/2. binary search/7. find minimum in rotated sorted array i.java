public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0)
        	return -1;

        int start = 0;
        int end = num.length - 1;
        while(start + 1 < end){
        	int mid = start + (end - start) / 2;
        	if(num[mid] > num[0] && num[mid] < num[num.length - 1])
        	    return num[0];
        	if(num[mid] > num[0]){
        	    start = mid;	
        	}else{
        		end = mid;
        	}
        }
        if(num[start] > num[end]){
            return num[end];
        }else{
            return num[start];
        }
    }
}