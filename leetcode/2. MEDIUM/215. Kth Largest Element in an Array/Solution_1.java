// 无赖方法，复杂度nlogn

public class Solution{
	public int findKthLargest(int[] nums, int k){
		final int n = nums.length;
		Arrays.sort(nums);
		return nums[n - k];
	}
}