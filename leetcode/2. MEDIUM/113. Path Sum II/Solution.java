public class Solution{
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> pathlist = new ArrayList<List<Integer>>();
		List<Integer> sumlist = new ArrayList<Integer>();
		pathSumHelper(root, sum, sumlist, pathlist);
		return pathlist;
	}

	public void pathSumHelper(TreeNode root, int sum, List<Integer> sumlist, List<List<Integer>> pathlist){
		if(root == null) return;
		sumlist.add(root.val);
		sum = sum - root.val;
		if(root.left == null && root.right == null){	// 已经到叶子节点
			if(sum == 0){
				pathlist.add(new ArrayList<Integer>(sumlist));	// 正好减完
			}
		}else{
			if(root.left != null)
				pathSumHelper(root.left, sum, sumlist, pathlist);
			if(root.right != null)
				pathSumHelper(root.right, sum, sumlist, pathlist);
		}
		sumlist.remove(sumlist.size() - 1);		// 为了移除最后一个多余添加进去的sum值
	}
}