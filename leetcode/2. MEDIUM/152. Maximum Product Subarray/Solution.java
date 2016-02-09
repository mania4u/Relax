public class Solution{
	public int maxProduct(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int max = nums[0], min = nums[0], res = nums[0];
		for(int i = 1; i < nums.length; i++){
			int tmp = max;
			// 之所以加入tmp是为了保存上一个循环的max值
			// 否则因为max变了，这样不能代入到min的判断里
			// 反正思路就是往绝对值大的方向走
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			// 因为存在负数，所以也需要比较min*nums[i]。因为存在两个负数相乘大于两个正数的情况
			min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
			if(max > res)	
				res = max;
		}
		return res;
	}
}