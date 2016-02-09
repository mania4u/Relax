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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int currentLevel = 1;   // 用来记录当前的循环次数
        int nextLevel = 0;      // 用来记录下一层有多少结点，作用更类似缓存tmp
        while(currentLevel != 0){
            ArrayList<Integer> currentLevelRes = new ArrayList<Integer>();
            nextLevel = 0;      // 每层需要清零上一层留下的nextLevel

            while(currentLevel != 0){
                TreeNode node = queue.poll();
                currentLevel--;     // 每次判断结点是否左右儿子之后，需要自减一次
                currentLevelRes.add(node.val);
                if(node.left != null){  // 判断是否有左儿子
                    queue.add(node.left);
                    nextLevel++;        // 当有左儿子，则下一层多加一个点
                }
                if(node.right != null){ // 与上面类似
                    queue.add(node.right);
                    nextLevel++;
                }
            }
            res.add(0, currentLevelRes);    // 逆序添加
            currentLevel = nextLevel;       // 下一层有多少儿子结点就需要循环多少次
        }
        return res;
    }
}