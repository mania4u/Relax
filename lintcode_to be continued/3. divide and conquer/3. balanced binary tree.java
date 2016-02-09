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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return maxDepth(root) != -1;
    } 

    private int maxDepth(TreeNode root){
        if(root == null) return 0;      // 到达树的最底层

        int left = maxDepth(root.left);     // 不是说左边结点所在的高度，而是以root.left为顶点整个左子树的高度
        int right = maxDepth(root.right);   // 同上
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
        // -1只是表示一个状态，而非真实长度，前两个判断条件是说明如果子树内已经出现不平衡的情况则直接return -1
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}