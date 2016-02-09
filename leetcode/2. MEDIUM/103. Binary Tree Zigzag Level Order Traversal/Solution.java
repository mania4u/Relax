public class Solution{
	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) return res;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int zig = 1;	// 用来标记倒序还是顺序
		int count = 0;
		TreeNode cur;
		while(queue.size() > 0){
			List<Integer> tmp = new ArrayList<Integer>();
			count = queue.size();
			for(int i = 0; i < count; i++){
				cur = queue.remove();
				if(zig % 2 == 0){
					tmp.add(0, cur.val);	// 倒序
				}else{
					tmp.add(cur.val);		// 顺序
				}
				// 下面的代码是用来添加分支下的结点
				if(cur.left != null){
					queue.add(cur.left);
				}
				if(cur.right != null){
					queue.add(cur.right);
				}
			}
			res.add(tmp);
			zig++;
		}
		return res;
	}
}