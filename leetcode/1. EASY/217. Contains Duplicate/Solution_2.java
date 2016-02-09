/*
	Time complexity: O(N lg N), memory: O(1) - not counting the memory used by sort
	利用自带的Arrays.sort()方法进行排序，直接前后比对
*/

public class Solution{
	public boolean containsDuplicate(int[] nums){
		Arrays.sort(nums);
		for(int ind = 1; ind < nums.length; ind++){
			if(nums[ind] == nums[ind - 1]){
				return true;
			}
		}
		return false;
	}
}