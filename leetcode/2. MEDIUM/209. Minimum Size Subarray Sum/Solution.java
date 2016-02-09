/*
	注意题目要求的是subarray，而非任取元素之和
	start作为开始标记，end作为结尾标记，长度用end-start+1来计算
	用end一路叠加，若小于s则继续叠加，若大于s，则减去nums[start]
*/
	
public class Solution{
	public int minSubArrayLen(int s, int[] nums){
		return solveN(s, nums);
	}

	public int solveN(int s, int[] nums){
		int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
		while(end < nums.length){
			while(end < nums.length && sum < s)
				sum += nums[end++];
			if(sum < s) break;	
			// 指当循环完，数组里所有值相加仍然小于s的情况
			while(start < end && sum >= s)
				sum -= nums[start++];
			if(end - start + 1 < minLen)
				minLen = end - start + 1;
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}