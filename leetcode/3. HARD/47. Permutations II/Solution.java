public class Solution{
	private List<List<Integer>> res;
	private List<Integer> list;
	private Set<Integer> visited;

	public List<List<Integer>> permuteUnique(int[] nums){
		res = new ArrayList<List<Integer>>();
		list = new ArrayList<Integer>();
		visited = new HashSet<>();
		Arrays.sort(nums);	// 很重要，否则下面的dfs会出错
		dfs(nums);
		return res;
	}

	private void dfs(int[] nums){
		if(list.size() == nums.length)
			res.add(new ArrayList<Integer>(list));
		else
			for(int i = 0; i < nums.length; i++){
				if(i > 0 && !visited.contains(i - 1) && nums[i - 1] == nums[i])
					continue;
				// 上面的判断其实并不影响最终结果，目的是为了让dfs能更快
				/*
					上面这一连串判断条件，重点在于要能理解!visited.contains(i-1)
					要理解这个，首先要明白i作为数组内的序号，i是唯一的
					给出一个排好序的数组，[1,2,2]
					第一层递归			第二层递归			第三层递归
					[1]					[1,2]				[1,2,2]
			   序号:[0]				 	[0,1]				[0,1,2]
			   		这种都是OK的，但当第二层递归i扫到的是第二个"2"，情况就不一样了
			   		[1]					[1,2]				[1,2,2]
			   序号:[0]					[0,2]				[0,2,1]
			   		所以这边判断的时候!visited.contains(0)就变成了true，不会再继续递归下去，跳出循环
			   		这步主要就是为了去除连续重复存在的，很神奇反正 = =||
				*/
				if(!visited.contains(i)){
					list.add(nums[i]);
					visited.add(i);
					dfs(nums);
					list.remove(list.size() - 1);
					visited.remove(i);
				}
			}
	}
}