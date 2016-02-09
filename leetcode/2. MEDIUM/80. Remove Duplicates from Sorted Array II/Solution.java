public class Solution{
	public int removeDuplicates(int[] nums){
		int i = 0;
		for(int n : nums){
			if(i < 2 || n > nums[i - 2])
			// 第一种情况：i<2代表最初始的状态
			// 第二种情况：因为是sorted，所以每当第三个数大于前二个的时候
				nums[i++] = n;
		}
		return i;
	}
}