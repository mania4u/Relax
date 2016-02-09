/*
    the highlight of the code below is:
    if(left == null || null)
        return left == right;
    the above code has the same meaning as:
    if(left == null && right == null) return true;
    if(left != null && right == null) return false;
    if(left == null && right != null) return false;
    if(left != null && right != null){
        if(left.val != right.val)
            return false;
    }
*/
public class Solution{
    public boolean isSymmetric(TreeNode root){
    if (root ==null) return true;
    return isSymmetricSubTree(root.left, root.right);
    }

    public boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left == null || right == null)   
            return left == right;
        if(left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
