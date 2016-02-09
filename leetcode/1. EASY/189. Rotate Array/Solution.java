// 最传统的方式，设置一个tmp用于存储，然后将tmp[]拷贝到nums[i]

public class Solution{
	public void rotate(int[] nums, int k){
		if(nums.length <= 1) return;

		int step = k % nums.length;
		int[] tmp = new int[step];
		for(int i = 0; i < step; i++){
			tmp[i] = nums[nums.length - step + i];
		}
		for(int i = nums.length - step - 1; i >= 0; i--){
			nums[i + step] = nums[i];
		}
		for(int i = 0; i < step; i++){
			nums[i] = tmp[i];
		}
	}
}