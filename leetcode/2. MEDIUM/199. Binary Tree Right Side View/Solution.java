public class Solution{
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		rightView(root, res, 0);
		return res;
	}

	public void rightView(TreeNode cur, List<Integer> res, int curDepth){
		if(cur == null) return;
		if(curDepth == res.size())
			res.add(cur.val);
		rightView(cur.right, res, curDepth + 1);
		rightView(cur.left, res, curDepth + 1);
	}
}