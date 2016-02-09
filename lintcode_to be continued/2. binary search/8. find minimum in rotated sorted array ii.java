public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0)
            return -1;
            
        int min = num[0];
        for(int i = 0; i < num.length - 1; i++){
            if(min > num[i + 1]){
                min = num[i + 1];
            }
        }
        return min;
    }
}