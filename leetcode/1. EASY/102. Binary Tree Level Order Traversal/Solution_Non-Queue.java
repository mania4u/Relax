// 思路和用queue的一样，只是多加一个过度的量

public class Solution{
	public List<List<Integer>> levelOrder(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        if(root == null) return result;
        level.add(root);
        while(!level.isEmpty()){
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (TreeNode node : level){
                currentLevel.add(node.val);
            if (node.left != null) 
                nextLevel.add(node.left);
            if (node.right != null) 
                nextLevel.add(node.right);
            }
        result.add(currentLevel);
        level = nextLevel;
        }
        return result;
    }
}