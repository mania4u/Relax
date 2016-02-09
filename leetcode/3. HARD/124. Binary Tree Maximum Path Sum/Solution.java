/*
	本题重在理解single和arch两者在递归时候的关系。
	从树的左下角开始，arch有点中序遍历的意思
	maxPath()这个函数返回的是single，也就是子树里单边能取得的最大值，然后继续往上一层走。
	而arch则是子树内两个叶子结点的路径和,注意是已经完结了的！single则没有完结！
	single和arch进行比较，结果储存在res内。
	当结点变高一层的父节点的时候，通过返回的single进行叠加，然后将结果与先前储存好的res进行比较。
	最终得出结果。
*/


public class Solution {
    int res;
	public int maxPathSum(TreeNode root) {
		res = Integer.MIN_VALUE;
		maxPath(root);
		return res;
	}

	private int maxPath(TreeNode root) {
	    if (root == null) 
	    	return 0;
	    int left = maxPath(root.left);
	    int right = maxPath(root.right);
	    int arch = left + right + root.val; 
	    int single = Math.max(root.val, Math.max(left, right) + root.val);
	    // 之所以要比较root和max(left,right)+root是因为考虑负数的情况
	    // 题目"寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束"，所以不一定是叶子结点
	    /*
	    	    -1
	    	-2      -3
 			  -4    
 				    	 
	    */
	    res = Math.max(res, Math.max(arch, single));
	    return single;		// 因为single还未完成所以是返回single
	}
}