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

// 递归方法
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
        }
    }
}

// 非递归方法，一层层的扫
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        int max = 0;
        if(root == null) return max;
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        path.push(root);
        sub.push(1);
        while(!path.empty()){
            TreeNode tmp = path.pop();
            int tmpVal = sub.pop();
            if(tmp.left == null && tmp.right == null){
                max = Math.max(max, tmpVal);
            }
            if(tmp.left != null){
                path.push(tmp.left);
                sub.push(tmpVal + 1);
            }
            if(tmp.right != null){
                path.push(tmp.right);
                sub.push(tmpVal + 1);
            }
        }
        return max;
    }
}