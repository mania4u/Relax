public class Solution{
	public List<String> findMissingRanges(int[] nums, int lower, int upper){
		List<String> res = new ArrayList<String>();
		// null check
		if(nums == null || lower > upper) return res;
		// empty case
		if(nums.length == 0){
			if(lower == upper)
				res.add(String.valueOf(lower))
			else
				res.add(low + "->" + upper);
		}
		// if lower is not in nums[]
		if(lower <= nums[0]){
			if(nums[0] == lower + 1)
				res.add(String.valueOf(lower));
			else
				res.add(lower + "->" + (nums[0] - 1));
		}
		// general case: both lower and upper are in the two boundaries
		for(int i = 0; i < nums.length - 1; i++){
			if(nums[i + 1] - nums[i] == 2)	// 间隔等于2，当中就夹一个数
				res.add(String.valueOf(nums[i] + 1));
			if(nums[i + 1] - nums[i] > 2)	// 间隔大于2
				res.add(String.valueOf((nums[i] + 1) + "->" + (nums[i + 1] -1)));
		}
		// if upper is not in nums[]
		int tail = nums[nums.length - 1];
		if(upper >= tail){
			if(tail == upper - 1)
				res.add(String.valueOf(upper));
			else
				res.add((tail + 1) + "->" + upper);
		}
	}
	return res;
}