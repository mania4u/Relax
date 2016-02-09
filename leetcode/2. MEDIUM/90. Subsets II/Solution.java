public class Solution{
	public List<List<Integer>> subsetsWithDup(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());
		int size = 0
		int startIndex = 0; // 用来标记非重复的数的坐标点
		for(int i = 0; i < num.length; i++){
			startIndex = (i >= 1 && num[i] == num[i - 1]) ? size : 0;	
			// 防重复,并更改startIndex的参数
			// 重复的数字每次从重复的第一个数字所产生的元素
			/*
				给出[1,2,2]
				第一个循环			第二个循环			第三个循环
				[]					[2]					[2,2]
				[1]					[1,2]				[1,2,2]
				第三个循环，也就是第二个"2"，这个"2"添加第二个循环增加的组合
				这也就是当有重复的数时，startIndex每次需要从size而非0开始
				若是不重复的数字，startIndex则是从0开始，需要全部添加
			*/
			size = res.size();
			for(int j = startIndex; j < size; j++){
				List<Integer> tmp = new ArrayList<>(res.get(j));
				tmp.add(nums[i]);
				res.add(tmp);
			}
		}
		return res;
	}
}