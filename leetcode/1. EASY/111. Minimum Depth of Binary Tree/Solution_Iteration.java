/*
	整段代码并不难，重点在于while循环if(cur == null)这个条件表达的意思。
	这个判断语句有两个作用：1. 让depth自加；2.给queue添加null
	queue中的null是一个结束标志，每次循环的时候，都会先添加树的结点，然后queue到底。
	也就是说，扫到null的时候，就停止扫这一层，并对下一层进行迭代。
*/
public class Solution{
	public int minDepth(TreeNode root){
		if(root == null) return 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int depth = 0;
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			if(cur == null){		// end of the level
				depth++;
				queue.offer(null);
			}else{
				if(cur.left == null && cur.right == null) return depth+1;
				if(cur.left != null) queue.offer(cur.left);
				if(cur.right != null) queue.offer(cur.right);
			}
		}
		return depth;
	}
}