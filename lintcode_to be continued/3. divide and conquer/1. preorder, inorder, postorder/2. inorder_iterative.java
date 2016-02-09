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
// 大致遍历的过程：先找到最左下角的那个结点然后找自己右子树，这点和先序遍历和后序遍历不一样
// 如果没有就往栈里找，然后循环这样的过程
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        TreeNode start = root;
        while(start != null || !stack.empty()){
        	while(start != null){
        	// 找最左下角的那个结点
        		stack.add(start);
        		start = start.left;
        	}
        	start = stack.peek();
        	res.add(start.val);
        	stack.pop(); 
        	start = start.right;
        }
        return res;
    }
}