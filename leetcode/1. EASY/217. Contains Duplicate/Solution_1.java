/*
Time complexity: O(N^2), memory: O(1)
The naive approach would be to run a iteration for each element 
and see whether a duplicate value can be found: this results in O(N^2) time complexity.
给定一个值，然后往前扫，最简单粗暴的方法
*/
public class Solution{
	public boolean containsDuplicate(int[] nums){
		for(int i = 0; i < nums.length; i++){
			for(int j = i + 1; j < nums.length; j++){
				if(nums[i] == nums[j]){
					return true;
				}
			}
		}
		return false;
	}
}