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
// 用的是中序遍历的方法，从左到右依次比较大小
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        
        if(root == null) return true;

        while(!stack.isEmpty() || cur != null){
        	if(cur != null){
        	// 向左递归，找到最左边的那个结点
        		stack.push(cur);
        		cur = cur.left;
        	}else{
        		TreeNode node =  stack.pop();
        		if(pre != null && node.val <= pre.val){
        		// 根据中序遍历pre肯定是在node的右侧，所以如果node.val <= pre.val即报错
        		// pre != null是为了防止出现空指针的情况，毕竟空指针是没有大小的
        			return false;
        		}
        		pre = node;				// 和上面判断条件pre != null相呼应
        		cur = node.right;		// 中序遍历，往右走
        	}
        }
        return true;
    }
}