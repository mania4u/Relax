/*
	DFS，下面的过程是从底层开始，每一层进行比较。
	记录下最深的层数后，然后往上走，用最深的和当前的层数相减进行比较
*/
public class Solution{
    public boolean isBalanced(TreeNode root){
        return maxDepth(root) != -1;		// -1是报错的状态表示，和层数没关系
    }

    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1)		
        // 之所以加"left == -1 || right == -1"这样的条件是因为当分支已经报错，就没必要用错的和同层的进行比较
            return -1;		
        return Math.max(left, right) + 1;	// 为的是找到最深的地方和
    }
}