public class Solution{
	public TreeNode invertTree(TreeNode root){
		if(root == null) return null;

		final Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);

		while(!stack.isEmpty()){
			final TreeNode node = stack.pop();
			final TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;

			if(node.left != null){
				stack.push(node.left);
			}
			if(node.right != null){
				stack.push(node.right);
			}
		}
		return root;
	}
}