// 重载
/*
	如果说给了一个链表1->2->3->4->5->6，他构造出来的应该是
			3
		  /   \
		 1	   5
 		  \	  / \	
	       2 4   6
	构造是从底部开始的
*/

public class Solution{
	static ListNode h;
	public TreeNode sortedListToBST(ListNode head){
		if(head == null) return null;
		h = head;
		int len = 0;
		ListNode tmp = head;
		while(tmp != null){		// 计算链表的长度
			len++;
			tmp = tmp.next;
		}
		return sortedListToBST(0, len - 1);
	}

	public TreeNode sortedListToBST(int start, int end){
		if(start > end) return null;
		int mid = start + (end - start) / 2;
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		root.left = left;
		h = h.next;		
		// 注意，h的值在每次root.left=left之后，已经变了
		// 所以后面递归right的时候，需要带入h的时候，带入h.next
		TreeNode right = sortedListToBST(mid + 1, end);
		root.right = right;
		return root;
	}
}