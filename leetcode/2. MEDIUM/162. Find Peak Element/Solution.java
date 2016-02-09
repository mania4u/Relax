// The array may contain multiple peaks, 
//in that case return the index to any one of the peaks is fine.
// 这题只需要找到任何一个peak即可
public class Solution{
	public int findPeakElement(int[] nums){
		return helper(nums, 0, nums.length - 1);
	}

	public int helper(int[] nums, int start, int end){
		if(start == end) return start;
		else if(start + 1 == end){
			if(nums[start] > nums[end]) return start;
			else return end;
		}else{
			int m = start + (end - start) / 2;
			if(nums[m] > nums[m - 1] && nums[m] > nums[m + 1])
				return m;
			else if(nums[m - 1] > nums[m] && nums[m] > nums[m + 1])
				return helper(nums, start, m - 1);
			else return helper(nums, m + 1, end);
		}
	}
}