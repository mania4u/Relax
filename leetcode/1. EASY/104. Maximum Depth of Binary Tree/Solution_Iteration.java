public class Solution{
	public int maxDepth(TreeNode root){
		if(root == null) return 0;
		int level = 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			if(cur == null){
				++level;
				if(!queue.isEmpty())
					queue.offer(null);
			}else{
				if(cur.left != null)
					queue.offer(cur.left);
				if(cur.right != null)
					queue.offer(cur.right);
			}
		}
		return level;
	}
}