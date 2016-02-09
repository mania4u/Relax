/*
	1. 中序遍历中根节点是左子树右子树的分割点。
	2. 后续遍历的最后一个节点为根节点。
	同样根据中序遍历找到根节点的位置，然后顺势计算出左子树串的长度。
	在后序遍历中分割出左子树串和右子树串，递归的建立左子树和右子树。

	本体是给了中序遍历和后序遍历，和之前给了先序遍历和中序遍历
	之所以每次rootVal是用pre和post是因为他们的根节点比较明显，
	pre是每次最开始的那个是根节点，post则是每次最后一个是根节点
*/
public class Solution{
	public TreeNode buildTree(int[] inorder, int[] postorder){
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);		
	}
	public TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd){
		if(inStart > inEnd || postStart > postEnd) return null;
		int rootVal = post[postEnd];
		int rootIndex = 0;
		for(int i = inStart; i <= inEnd; i++){
			if(in[i] == rootVal){
				rootIndex = i;
				break;
			}
		}
		int len = rootIndex - inStart;
		TreeNode root = new TreeNode(rootVal);
		root.left = buildTree(in, inStart, rootIndex - 1, post, postStart, postStart + len - 1);
		root.right = buildTree(in, rootIndex + 1, inEnd, post, postStart + len, postEnd - 1);
		// 这里和每次的根节点都会出现在右子树那边
		return root;
	}
}