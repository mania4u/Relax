public class Solution{
	public void reorderList(ListNode head){
		if(head == null || head.next == null) return;
		ListNode slow = head;
		ListNode fast = head;
		ListNode firsthalf = head;
		while(fast.next != null && fast.next.next != null){		
		// 为了将平分成两段
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode secondhalf = slow.next;
		slow.next = null;
		secondhalf = reverseOrder(secondhalf);
		while(secondhalf != null){
			ListNode tmp1 = first.next;
			ListNode tmp2 = secondhalf.next;
			firsthalf.next = secondhalf;
			secondhalf.next = tmp1;
			firsthalf = tmp1;
			secondhalf = tmp2;
		}
	}

	// 用来逆序链表
	public static ListNode reverseOrder(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null){
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		head.next = null;
		return pre;
	}
}