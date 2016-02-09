/*
	题目难度本身不大，但要理清他循环是怎么运作的。
	先给数组安排个初始值[[num[0]]](这个是二维数组)。
	第一个循环用来控制加入的数字，第二个则用来控制数字的不同位置。
	重点是foreach循环，每次foreach都会调用之前每次循环结束后的ans数组
	ans数组是每次完成的数组，用来存储保存好的结果。
	在每次foreach循环中，都会重新new一个新的子数组，而这个子数组每次都通过ans数组来赋值
*/

public class Solution{
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();	// 大数组
		if(nums.length == 0) return res;
		List<Integer> sub = new ArrayList<Integer>();	// 大数组内的小数组
		sub.add(nums[0]);
		res.add(sub);
		for(int i = 1; i < nums.length; i++){
			List<List<Integer>> new_res = new ArrayList<List<Integer>>();
			for(int j = 0; j <= i; j++){
				for(List<Integer> x : res){
					List<Integer> new_sub = new ArrayList<Integer>(x);
					new_sub.add(j, nums[i]);
					new_res.add(new_sub);
				}
			}
			res = new_res;
		}
		return res;
	}
}