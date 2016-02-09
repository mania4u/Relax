public class Solution{
	public boolean isSameTree(TreeNode p, TreeNode q){
		LinkedList<TreeNode> pStack = new LinkedList<TreeNode>();
		LinkedList<TreeNode> qStack = new LinkedList<TreeNode>();
		pStack.push(p);
		qStack.push(q);
		while(!pStack.isEmpty() && !qStack.isEmpty()){
			TreeNode pCur = pStack.poll();
			TreeNode qCur = qStack.poll();
			if(pCur == null && qCur == null) continue;
			if(pCur == null || qCur == null) return false;
			if(pCur.val != qCur.val) return false;
			pStack.push(pCur.left);
			pStack.push(pCur.right);
			qStack.push(qCur.left);
			qStack.push(qCur.right);
		}
		return true;
	}
}