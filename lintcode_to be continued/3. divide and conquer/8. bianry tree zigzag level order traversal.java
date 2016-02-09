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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        int currentLevel = 1;   // 用来记录当前的循环次数
        int nextLevel = 0;      // 用来记录下一层有多少结点，作用更类似缓存tmp
        int whichLevel = 0;     // 用来记录当前的层数，因为奇数层和偶数层输出方向相反，需要一个flag来标记    
        while(currentLevel != 0){
            ArrayList<Integer> currentLevelRes = new ArrayList<Integer>();
            nextLevel = 0;      // 每层需要清零上一层留下的nextLevel

            while(currentLevel != 0){
                TreeNode node = queue.poll();
                currentLevel--;     // 每次判断结点是否左右儿子，需要自减一次
                if(whichLevel % 2 == 1){    // 奇数层逆序输出
                    currentLevelRes.add(0, node.val);
                }else{                      // 偶数层顺序输出
                    currentLevelRes.add(node.val);
                }
                if(node.left != null){  // 判断是否有左儿子
                    queue.add(node.left);
                    nextLevel++;        // 当有左儿子，则下一层多加一个点
                }
                if(node.right != null){ // 与上面类似
                    queue.add(node.right);
                    nextLevel++;
                }
            }
            res.add(currentLevelRes);       // 
            currentLevel = nextLevel;       // 传递，下一层有多少儿子结点就需要循环多少次
            whichLevel++;                   // 树的层数+1
        }
        return res;
    }
}