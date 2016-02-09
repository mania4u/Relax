public class Solution{
	public ListNode swapPairs(ListNode head){
		if(head == null || head.next == null) return head;	// 单数个，最后多出的那个node不变
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while(cur != null && cur.next != null){
			ListNode tmp = cur.next.next;	// 存储起来，因为操作的是前面的node
			cur.next.next = cur;	// 反向从cur.next指回cur
			pre.next = cur.next;	// pre断掉和cur的链接，和cur.next相连
			cur.next = tmp;		// cur断掉和cur.next的链接，和之前保存的cur.next.next相连
			pre = cur;		// 迭代条件
			cur = pre.next;	// 同上
		}
		return dummy.next;
	}
}