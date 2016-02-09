public class Solution{
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		getResult(result, new ArrayList<Integer>(), candidates, target, 0);
		return result;
	}

	private void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start){
		if(target > 0){
			for(int i = start; i < candidates.length && target >= candidates[i]; i++){
				cur.add(candidates[i]);
				getResult(result, cur, candidates, target - candidates[i], i);
				cur.remove(cur.size() - 1);		
				// 上面加这一步是因为每次都是先添加再判断（这里最重要），所以如果不满足循环条件，必定会多最后一个元素。
				// 如果是满足条件了的话，直接跳转到else if这个从句下面
			}
		}else if(target == 0){
			result.add(new ArrayList<Integer>(cur));
		}
	}
}