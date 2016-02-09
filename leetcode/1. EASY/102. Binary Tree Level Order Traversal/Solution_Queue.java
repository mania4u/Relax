/*
	非常典型的queue题目。重点在于对queue结构上的理解。
	这道题大致的思路是：
	将root放入队列，如果队列不为空，进行一个for循环，内容是将这一层node以下的node加入到队列，并弹出这一层node的值。
	node有多少个，就会有多少次的subList.add()。过程就是“加入下一层的node --> 移除本层的node --> 加入下一层的node”这样循环
*/

public class Solution{
	public List<List<Integer>> levelOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		if(root == null) return wrapList;
		queue.offer(root);
		while(!queue.isEmpty()){
			int levelNum = queue.size();	
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++){		
				if(queue.peek().left != null)
					queue.offer(queue.peek().left);
				if(queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);		
			}
			wrapList.add(subList);
		}
		return wrapList;
	}
}