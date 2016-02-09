public class Solution{
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur != null || !stack.empty()){
			if(cur != null){
				stack.add(cur);
				cur = cur.left;		// 往左子树走到底，然后pop
			}else{
			    cur = stack.pop();
			    list.add(cur.val);
			    cur = cur.right;
		    }
	    }
	    return list;
    }
}