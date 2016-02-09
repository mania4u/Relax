public class Solution{
	public LinkedList<LinkedList<Integer>> levelOrderBottom(TreeNode root){
		LinkedList<LinkedList<Integer>> rst = new LinkedList<LinkedList<Integer>>();
		if(root == null) 
			return rst;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		int cur = 1, next = 0;
		while(!queue.isEmpty()){
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			while(cur > 0){
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.add(node.left);
					next++;
				}
				if(node.right != null){
					queue.add(node.right);
					next++;
				}
				tmp.add(node.val);
				cur--;
			}
			rst.addFirst(tmp);
			cur = next;
			next = 0;
		}
		return rst;
	}
}