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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return res;

        queue.add(root);
        while(!queue.isEmpty()){
        	ArrayList<Integer> level = new ArrayList<Integer>();
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
        		TreeNode head = queue.poll();
        		level.add(head.val);
        		if(head.left != null){
        			queue.add(head.left);
        		}
        		if(head.right != null){
        			queue.add(head.right);
        		}
        	}
        	res.add(level);
        }
        return res;
    }
}