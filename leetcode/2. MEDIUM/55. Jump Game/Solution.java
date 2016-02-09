// 题目小陷阱，不是说每次要照着数组里的值a跳，而是每部能最多跳a步
// 所以只需要比较每一个数组的值能走到的最大步数即可，这个值应该是大于等于数组的长度

public class Solution{
	public boolean canJump(int[] nums){
		int max = 0;
		for(int i = 0; i < nums.length; i++){
			if(i > max) return false;
			max = Math.max(nums[i] + i, max);
		}
		return true;
	}
}