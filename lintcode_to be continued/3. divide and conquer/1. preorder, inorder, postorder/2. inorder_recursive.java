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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        traverse(res, root);
        return res;
    }

    private void traverse(ArrayList<Integer> res, TreeNode root){
    	if(root == null) return;
    	traverse(res, root.left);
    	res.add(root.val);
    	traverse(res, root.right);
    }
}