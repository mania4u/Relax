/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

// 贪心算法，保证每部分子树是最大从而得到最大的路径值
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    
    int res;
    public int maxPathSum(TreeNode root) {
        // write your code here
        res = Integer.MIN_VALUE;
        maxPath(root);
        return res;
    }

    private int maxPath(TreeNode root){
        if(root == null) return 0;

        // 标准divide and conquer
        int left = maxPath(root.left);
        int right = maxPath(root.right);

        int arch = left + right + root.val;     
        // arch是已完结的状态，是一条开口向下的半圆
        int single = Math.max(root.val, Math.max(left, right) + root.val);
        // single则是未完结的状态，右子树+结点值或者左子树+结点值，然后挑较大的那个
        // 之所以要比较root和max(left,right)+root是因为考虑负数的情况
        // 题目"寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束"，所以不一定是叶子结点
        /*
                -1
            -2      -3
              -4    
                         
        */
        res = Math.max(res, Math.max(single, arch));
        return single;      // 这边return single是因为arch已经是完结的状态，single则是未完成的
    }
}