/*
	若树一共有n个结点，树的高度为logn
	分两种情况：	1.若最后的叶子结点落在左子树，则说明到logn-1层为止是满二叉树
					  结点数等于2^(logn-1)-1
					2.若最后的叶子结点落在右子树，等于剥离左子树和root结点
					  说明左子树肯定是满二叉树，加上root这个结点，等于2^(logn-1)
*/
					  
public class Solution{
	int height(TreeNode root){
		return root == null ? -1 : 1 + height(root.left);
		// 注意这边如果root是null的话，返回的是-1而不是0
		// 所以到下面如果出现1<<-1，等同于1>>1，值返回的是0
	}

	public int countNodes(TreeNode root){
		int nodes = 0, h = height(root);
		while(root != null){
			if(height(root.right) == h - 1){
			// 最后的叶子结点落在右子树
				nodes += 1 << h;
				root = root.right;
			}else{
			// 最后的叶子结点落在左子树
				nodes += 1 << h - 1;
				root = root.left;
			}
			h--;
		}
		return nodes;	
	}
}