/*
	通过先序遍历找到第一个点作为根节点，在中序遍历中找到根节点并记录index。
	因为中序遍历中根节点左边为左子树(这句话尤其重要)，
	所以可以记录左子树的长度并在先序遍历中依据这个长度找到左子树的区间，
	用同样方法可以找到右子树的区间。递归的建立好左子树和右子树就好。
*/

public class Solution{
	public TreeNode buildTree(int[] preorder, int[] inorder){
		return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	public TreeNode buildTree(int[] pre, int preStart, int preEnd, int inStart, int inEnd){
		if(inStart > inEnd || preStart > preEnd) return null;
		int rootVal = pre[preStart];
		int rootIndex = 0;
		for(int i = inStart; i <= inEnd; i++){
			if(in[i] == rootVal){
				rootIndex = i;		// 找到先序遍历的根节点在中序遍历中的位置
				break;
			}
		}
		int len = rootIndex - inStart;	// 根节点左边子树的长度
		TreeNode root = new TreeNode(rootVal);	
		root.left = buildTree(pre, preStart + 1, preStart + len, in, inStart, rootIndex - 1);
		// 从preStart+1到preStart+len是先序遍历的左半段，preStart+1是因为剔除了第一个根节点
		// 从inStart到rootIndex-1是中序遍历的左半段，rootIndex-1是因为提出根节点
		root.right = buildTree(pre, preStart + len + 1, preEnd, in, rootIndex + 1, inEnd);
		// 从preStart+len+1到preEnd是先序遍历的右半段，从rootIndex+1到inEnd则是中序遍历的右半段
		// 这边中点只可能存在于root.left，因为是因为根节点来分隔root.left和root.right
		// 根节点出现在先序遍历的第一个，中序遍历的最中间
		return root;
	}
}