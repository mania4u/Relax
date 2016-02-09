/*
	中序遍历的思路。用栈来保存从根到最左侧叶子节点的路径，
	栈最上面的结点是最小的结点，每次取next,都是取栈最上面的结点，
	然后把剩余结点到最左侧叶子节点的路径放入栈中。
*/

public class BSTIterator{
	private Stack<TreeNode> stack;
	public BSTIterator(TreeNode root){
		stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null){
			stack.push(cur);
			if(cur.left != null)
				cur = cur.left;
			else 
				break;
		}
	}

	public boolean hasNext(){
		return !stack.isEmpty();
	}

	// 这里next主要是针对右子树，因为左子树只需要每次pop()
	// 返回parent node即可。从右子树里，往左结点一直迭代下去便是下一个最小值
	public int next(){
		TreeNode node = stack.pop();
		TreeNode cur = node;
		if(cur.right != null){
			cur = cur.right;
			while(cur != null){
				stack.push(cur);
				if(cur.left != null)
					cur = cur.left;
				else 
					break;
			}
		}
		return node.val;
	}
}