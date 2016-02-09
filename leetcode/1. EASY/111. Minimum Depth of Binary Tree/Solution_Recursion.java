public class Solution{
	public int minDepth(TreeNode root){
		if(root == null) return 0;	
		if(root.left == null && root.right == null) return 1;
		if(root.left == null || root.right == null) return root.left == null ? 1+minDepth(root.right) : 1+minDepth(root.left);
		return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
	}
}