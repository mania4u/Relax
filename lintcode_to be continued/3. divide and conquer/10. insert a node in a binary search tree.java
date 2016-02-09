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

// 非递归法
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) return node;
        
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null){
        // while循环用来寻找父亲结点，但不能判断最后父亲结点位置后具体放在左边还是右边
        // 在最后一个循环cur会指向null
            pre = cur;
            if(cur.val > node.val){
                cur = cur.left;
            }else if(cur.val < node.val){
                cur = cur.right;
            }
        }
        if(pre != null)
        // 用来决定最后的node是放在上一层父亲结点的左边还是右边
            if(pre.val > node.val){
                pre.left = node;
            }else if(pre.val < node.val){
                pre.right = node;
            }
        }
        return root;
    }
}

// 递归法
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) return node;
        
        if(root.val > node.val){
            root.left = insertNode(root.left, node);
        }else if(root.val < node.val){
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}