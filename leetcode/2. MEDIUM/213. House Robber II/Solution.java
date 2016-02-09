/*
	simpleRob()即使以house robber i那道题，增加了start和end两个变量
	其实所谓的环就是考虑两种情况：
	1. 0到n-2，这种情况转到新的一圈，以0为起始点，则和先前一圈一样的结果
	2. 1到n-1，这种情况能走到0到n-2情况下，一辈子到不了的n-1
	两种情况一走

*/

public class Solution{
	public int rob(int[] nums){
		int n = nums.length;
		if(n == 1){
			return nums[0];
		}else{
			return Math.max(simpleRob(nums, 0, n - 2), simpleRob(nums, 1, n - 1));
		}
	}

	public int simpleRob(int[] nums, int start, int end) {
        int h1 = 0, h2 = 0;
        for (int i = start; i <= end; i++){
            int temp = h1;
            h1 = Math.max(h1, h2);
            h2 = nums[i] + temp;
        }
        return Math.max(h1, h2);
    }
}