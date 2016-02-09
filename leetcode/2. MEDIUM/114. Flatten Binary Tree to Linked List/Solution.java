/*
	还是DFS，先遍历到最右侧的叶子结点，然后同一层的左结点
	再往上走，然后继续递归
*/
public class Solution{
	private TreeNode prev = null;
	public void flatten(TreeNode root){
		if(root = null) return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
}