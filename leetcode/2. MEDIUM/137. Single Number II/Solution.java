/*
	这题的重点在于，如果说一个数字出现三次，
	那他对应二进制的累加一定会出现3的背熟，
	而多余的那个数字会造成3n+1的效果，
	所以我们通过取余把多余的“1”提取出来
	这边需要做的是用一个数组记录，也就是cnt数组，
	注意这个数组是十进制的

*/
public class Solution{
	public int singleNumber(int[] nums){
		if(nums.length == 0 || nums == null) return 0;

		int[] cnt = new int[32];
		for(int i = 0; i < nums.length; i++){
			for(int j = 0; j < 32; j++){
				if((nums[i] >> j & 1) == 1){
					cnt[j]++;
				}
			}
		}
		int res = 0;
		for(int i = 0; i < 32; i++){
			res += (cnt[i] % 3 << i);	
			// 将每个第i位，统一移到第一位
		}
		cnt = null;	// 清零cnt数组
		return res;
	}
}