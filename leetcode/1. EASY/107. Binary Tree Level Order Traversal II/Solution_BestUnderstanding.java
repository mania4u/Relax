public class Solution{
	public LinkedList<LinkedList<Integer>> levelOrderBottom(TreeNode root){
		LinkedList<LinkedList<Integer>> rst = new LinkedList<LinkedList<Integer>>();
		if(root == null) return rst;
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();		// used for storing the of the current level and marking
		queue.add(root);
		while(!queue.isEmpty()){
			ArrayList<TreeNode> next = new ArrayList<TreeNode>();	// store all the nodes for next level
			LinkedList<Integer> tmp = new LinkedList<Integer>();	// store all the values of the nodes in this level
			for(TreeNode node: queue){
				if(node.left != null) next.add(node.left);
				if(node.right != null) next.add(node.right);
				tmp.add(node.val);		// add all the nodes 
			}
			rst.addFirst(tmp);		// addFirst = add(0, blablabla)
			queue = next;		// replace the previous
		}
		return rst;
	}	
}