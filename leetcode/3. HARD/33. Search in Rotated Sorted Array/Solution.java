public class Solution{
	public int search(int[] nums, int target){
		if(nums.length == 0) return -1;
		int l = 0, r = nums.length - 1;
		if(target < nums[l] && target > nums[r]) return -1;
		while(l < r){
			int m = l + (r - l) / 2;
			if(nums[m] <= nums[r]){
				if(target > nums[m] && target <= nums[r]){
					l = m + 1;
				}else{
					r = m;
				}
			}else{
				if(target <= nums[m] && target >= nums[l]){
					r = m;
				}else{
					l = m + 1;
				}
			}
		}
		if(nums[l] == target) return l;
		else return -1;
	}
}