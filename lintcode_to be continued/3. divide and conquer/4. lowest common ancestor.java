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
// 标准的divide and conquer模版
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null || root == A || root == B){
        // 这步是递归时候，用来搜寻底部的叶子结点、A结点和B结点
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        // 下面一共叙述了四种搜索时候遇到的情况
        if(left != null && right != null){
        // 1. left和right找到A结点和B结点
        //    那对应的root就是要找的祖先
            return root;
        }else if(left != null && right == null){
        // 2. 只有在左子树找到所要找的结点，而右子树没有
        //    注意由于是一搜索到结点A就返回，如果说结点B存在于以结点A的子树内，所以就搜不到B
        //    这样的话，很明显结点A就是我们要找的祖先
            return left;
        }else if(right != null && left == null){
        // 同上
            return right;
        }else{
        // 4. left和right都没找到A结点和B结点
            return null;
        }      
    }
}