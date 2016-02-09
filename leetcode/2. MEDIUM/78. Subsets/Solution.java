// 开始是res只含有一个空集，然后随着res的积累
// 第二个for循环里的内容越来越多，每次循环的次数会以1,2,4,8...这样的指数形式增加
/*
	给出[1,2,3]
	第一个循环			第二个循环			第三个循环
	[]					[2]					[3],[1,3]
	[1]					[1,2]				[2,3],[1,2,3]
	第三个循环，也就是第二个"2"，这个"2"添加第二个循环增加的组合
	这也就是当有重复的数时，startIndex每次需要从size而非0开始
	若是不重复的数字，startIndex则是从0开始，需要全部添加
*/

public class Solution{
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());	// 空集
		Arrays.sort(nums);
		for(int i : nums){
			List<List<Integer>> tmp = new ArrayList<>();
			for(List<Integer> sub : res){
				List<Integer> a = new ArrayList<>(sub);
				a.add(i);
				tmp.add(a);
			}
			res.addAll(tmp);
			// 将tmp内所有的元素添加到res中，而不是将tmp本身直接添加进去
		}
		return res;
	}
}