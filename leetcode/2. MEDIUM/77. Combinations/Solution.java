// DFS经典题型 
// http://blog.csdn.net/u010500263/article/details/18435495

public class Solution{
	public static List<List<Integer>> combine(int n, int k){
		List<List<Integer>> combSet = new ArrayList<List<Integer>>();
		List<Integer> comb = new ArrayList<Integer>();
		if(n < k) return combSet;
		helper(n, k, combSet, comb, 1);
		return combSet;
	}

	public static void helper(int n, int k, List<List<Integer>> combSet, List<Integer> comb, int start){
		if(comb.size() == k){
			combSet.add(new ArrayList<Integer>(comb));
			return;
		}else{
			for(int i = start; i <= n; i++){
				comb.add(i);
				helper(n, k, combSet, comb, i + 1);	
				// 选定一个数字之后，进行新的递归，并且每次添加一个新的后续数字，所以不会重复
				// 没满足则继续递归，满足条件后跳转到if语句
				comb.remove(comb.size() - 1);	// 每当comb的size到k，则返回并添加在combSet内
			}
		}
	}
}