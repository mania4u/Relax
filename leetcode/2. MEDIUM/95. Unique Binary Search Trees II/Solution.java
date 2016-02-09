/*
	介绍的在循环中调用递归函数求解子问题。思路是每次一次选取一个结点为根，
	以(1,3)为例，大循环一共三次，衍生了三对递归
	(1,0)和(2,3); (1,1)和(3,3); (1,2)和(4,3)
	其实递归最主要的只是添加每次大循环的结点i的值，
	因为lefts和rights肯定是空集，主要就是null的位置
*/
public class Solution{
	public ArrayList<TreeNode> generateTrees(int n){
		return generateTrees(1, n);
	}

	private ArrayList<TreeNode> generateTrees(int left, int right){
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if(left > right){
			res.add(null);
			return res;
		}
		for(int i = left; i <= right; i++){	// 根节点
			ArrayList<TreeNode> lefts = generateTrees(left, i - 1);		// 递归左半边的子树
			ArrayList<TreeNode> rights = generateTrees(i + 1, right);	// 递归右半边的子树
			for(TreeNode l : lefts){
				for(TreeNode r : rights){
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
}